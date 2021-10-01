import React from 'react';
import { mount } from 'enzyme';
import { PrivateRoute } from '../../routers/PrivateRoute';
import { MemoryRouter } from 'react-router-dom';

describe('Pruebas en <PrivateRoute />', () => {
    
    const props = {
        location: {
            pathname: '/marvel'
        }
    }

    //mockeamos la funcion setItem de localStorage
    Storage.prototype.setItem = jest.fn();

    test('debe de mostrar el componente si está autenticado y guardar localStorage', () => {
        
        //renderizamos el componente con mount para que evuelva Tanto a memoryRouter como a privateRoute
        const wrapper = mount(
            // para hacer pruebas con rutas
            <MemoryRouter>  {/*  high order component para testear rutas*/}
                <PrivateRoute 
                //simulamos mandar los argumentos del componente
                    isAuthenticated={ true }
                    component={ () => <span>Listo!</span> } //se manda cualquier funcion
                    { ...props } // y los demas props que es el objeto props de arriba
                />
            </MemoryRouter>
        );
            //me interesa ver que el span exista
        expect( wrapper.find('span').exists() ).toBe(true);
        //lastPath --> asi se llama en el PrivateRoute y se le manda una ruta por ejemplo '/Marvel'
        expect( localStorage.setItem ).toHaveBeenCalledWith('lastPath', '/marvel');


    })


    test('debe de bloquear el componente si no está autenticado', () => {
        
        const wrapper = mount(
            <MemoryRouter>
                <PrivateRoute 
                    isAuthenticated={ false }
                    component={ () => <span>Listo!</span> }
                    { ...props }
                />
            </MemoryRouter>
        );

        expect( wrapper.find('span').exists() ).toBe(false);
        expect( localStorage.setItem ).toHaveBeenCalledWith('lastPath', '/marvel');

    });
    
    

})
