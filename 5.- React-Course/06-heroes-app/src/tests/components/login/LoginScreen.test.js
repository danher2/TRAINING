import React from 'react';
import { mount } from 'enzyme';
import { LoginScreen } from '../../../components/login/LoginScreen';
import { AuthContext } from '../../../auth/AuthContext';
import { types } from '../../../types/types';

describe('Pruebas en <LoginScreen />', () => {
    
    //necesitamor la funcion replace del history para en viarlo por el comoponente LoginScreen
    const history = {
        replace: jest.fn()
    }

    //nel dispatch y el user del contextValue para mandarlo a traves del Higher component Provider a los hijos
    const contextValue = {
        dispatch: jest.fn(), //mockeamos la funcion
        user: {
            logged: false //fijamos el valor en false
        }
    }

    const wrapper = mount(
        <AuthContext.Provider value={ contextValue }> {/* envolvemos a LoginScren porque   en realildad extrae el contextValue dell AuthCOntext */}

            <LoginScreen history={ history } /> {/*  Mandamos el history a traves del componente LoginScreen*/} 

        </AuthContext.Provider>
    )

    test('debe de mostrarse correctamente', () => {
        // se muestre contra el snpshot
        expect( wrapper ).toMatchSnapshot();

    });


    test('debe de realizar el dispatch y la navegación', () => {
        
        //simulamos el clin y lo guardamos enuuna constante
        const handleClick = wrapper.find('button').prop('onClick');

        handleClick();

        //esperaria que el dispatch  haya sido llamado con  eseobjeto (puesto en duro en LoginScreen)
        expect( contextValue.dispatch ).toHaveBeenCalledWith({
            type: types.login,
            payload: {
                name: 'Daniel'
            }
        });
        
        //esperariamos que replace del hisroty haya sido llamado con la url '/'
        expect( history.replace ).toHaveBeenCalledWith('/');

        //simulamos grabar algo en el localStorage
        localStorage.setItem('lastPath','/dc');

        //simulamos el clink despues
        handleClick();
        //y esperamos que el replace del history haya sido llamado ahora con  '/dc'
        expect( history.replace ).toHaveBeenCalledWith('/dc');
    })
    
    

})
