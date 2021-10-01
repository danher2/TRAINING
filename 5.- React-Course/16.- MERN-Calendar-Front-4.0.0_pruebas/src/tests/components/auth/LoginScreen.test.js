import React from 'react';
// imporramos mout para envolver componentes e hijos en el snapshit
import { mount } from 'enzyme';

// importamor el provider para simular el escenario desde arriba, proveeyendo toda la info a la app y los estados
import { Provider } from 'react-redux';

//importamos el mock store, thuk y sweet alert
import configureStore from 'redux-mock-store';
import thunk from 'redux-thunk';
import Swal from 'sweetalert2';

// importamos la libreria de mockeo de funciones del dom
import '@testing-library/jest-dom';
// importamos  los componentes que usaremos
import { LoginScreen } from '../../../components/auth/LoginScreen';
import { startLogin, startRegister } from '../../../actions/auth';

// simulamos las funciones del startLogin y startRegister
jest.mock('../../../actions/auth', () => ({
    startLogin: jest.fn(),
    startRegister: jest.fn()
}));

// tmb simulamos el sweet alert
jest.mock('sweetalert2', () => ({
    fire: jest.fn(),
}));

// creamos el middleware
const middlewares = [ thunk ];
const mockStore = configureStore( middlewares );

// creamos el store
const initState = {};
const store = mockStore( initState );
store.dispatch = jest.fn();

// le proveemos los estrados del store con un wrapper
const wrapper = mount(
    <Provider store={ store } >
        <LoginScreen />
    </Provider>
);



describe('Pruebas en <LoginScreen />', () => {

    // limpiamos los mocks en cada prueba
    beforeEach(() => {
        jest.clearAllMocks(); // siempre limpiamos los mocks despues de que se usen en cada test
    })


    test('debe mostrarse correctamente', () => {
// hacemos el snapshot
        expect( wrapper ).toMatchSnapshot();
        
    });


    test('debe de llamar el dispatch del login', () => {
        
        // simulamos el llenado de los inputs email, password
        wrapper.find('input[name="lEmail"]').simulate('change', {
            target: {
                name: 'lEmail',
                value: 'juan@gmail.com',
            }
        });

        wrapper.find('input[name="lPassword"]').simulate('change', {
            target: {
                name: 'lPassword',
                value: '123456',
            }
        });

        // simulamor el submit
        wrapper.find('form').at(0).prop('onSubmit')({
            preventDefault(){}
        });

        // esperamos qu eel startLogin haya sido llamado con esas credenciales
        expect( startLogin ).toHaveBeenCalledWith('juan@gmail.com','123456');

    })
    
    test('No hay registro si las contraseñas son diferentes', () => {

        // encuentra el password1 y simula introducir la pass
        wrapper.find('input[name="rPassword1"]').simulate('change', {
            target: {
                name: 'rPassword1',
                value: '123456', // la pass aqui es 123456
            }
        });

        // encuentra el input del password2 y simula introducrila la pass
        wrapper.find('input[name="rPassword2"]').simulate('change', {
            target: {
                name: 'rPassword2',
                value: '1234567', // la pass aqui es diferente a 123456
            }
        });
        
// simulamos el submit
        wrapper.find('form').at(1).prop('onSubmit')({
            preventDefault(){} // evitamos el refresh
        });

        // esperamos que starRegister no haya sido llamado
        expect( startRegister ).not.toHaveBeenCalled();
        // esperamos que Swal se haya llamado con el mensaje correspondiente
        expect( Swal.fire ).toHaveBeenCalledWith('Error', 'Las contraseñas deben de ser iguales','error');
    
    })
    

    test('Registro con contraseñas iguales', () => {
        // encuentra el  input del password register y simula introducir la pass "hola mundo"
        wrapper.find('input[name="rPassword1"]').simulate('change', {
            target: {
                name: 'rPassword1',
                value: 'hola mundo',
            }
        });

        // encuentra el  input del password2 register y simula introducir la pass "hola mundo , que es igual a la primera"
        wrapper.find('input[name="rPassword2"]').simulate('change', {
            target: {
                name: 'rPassword2',
                value: 'hola mundo',
            }
        });
        
// simula el onSubmit
        wrapper.find('form').at(1).prop('onSubmit')({
            preventDefault(){}
        });

        // ahora esperamos que el Swal.fire no hayaa sido llamado
        expect( Swal.fire ).not.toHaveBeenCalled(); // no se llama este porque , las contrasenas si son iguales
        // y que startRegister si haya sido llamado con esas credenciales porque las dos passwords si eran iguales
        expect(  startRegister ).toHaveBeenCalledWith('nando@gmail.com', 'hola mundo', 'Nando');
    
    })
    

    
    
})
