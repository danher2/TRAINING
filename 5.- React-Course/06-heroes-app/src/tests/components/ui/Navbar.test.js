import React from 'react';
import { mount } from 'enzyme';
import { MemoryRouter, Router } from 'react-router-dom';
import '@testing-library/jest-dom';

import { AuthContext } from '../../../auth/AuthContext';
import { Navbar } from '../../../components/ui/Navbar';
import { types } from '../../../types/types';



describe('Pruebas en <Navbar />', () => {
// mockeamos  el history y algunas de sus fnciones se usa en el Router
    const historyMock = { //establecemos todas las propiedades de nuestro history mock si no nos dara error
        push: jest.fn(),
        replace: jest.fn(),
        location: {},
        listen: jest.fn(),
        createHref: jest.fn()
    }

    //contexto de la action y el user logged se usa en el AuthContext.Provider
    const contextValue = {
        dispatch: jest.fn(), // simulamos la accion del dispatch
        user: {
            logged: true,
            name: 'Pedro'
        }
    }

    //wrapper  con  mount porque se manda context a los hijos
    const wrapper = mount(
        <AuthContext.Provider value={ contextValue }>
            <MemoryRouter>{/* se trabaja con Routas entonces se usa este componente */} 
                <Router history={ historyMock }> {/* dentro del Componente Router se manda el history el cual esta mockeado arriba con sus funciones */} 
                    <Navbar />
                </Router>
            </MemoryRouter>
        </AuthContext.Provider>
    );

    //ciclo de vida despues de cada prueba limpiar todos los mocks
    //es una buena practica
    afterEach(() => {
        jest.clearAllMocks();
    });

    test('debe de mostrarse correctamente', () => {
      //se hace snapashot
        expect( wrapper ).toMatchSnapshot();
      //esperaria que en el elemento que tenga el  className .text-info se encuentre pedro
        expect( wrapper.find('.text-info').text().trim() ).toBe('Pedro');

    });

    test('debe de llamar el logout y el usar history', () => {
        //se dispara el boton click
        wrapper.find('button').prop('onClick')();
        console.log('click')

        //evaluamos si el dispatch fue llamado en el clik de arriba con un objeto que tenia el type de logout
        expect( contextValue.dispatch ).toHaveBeenCalledWith({
            type: types.logout
        });

        //esperamos que metodo replace del historyMock haya sido llamado con un String
        expect( historyMock.replace ).toHaveBeenCalledWith('/login');

    })
    
    

})
