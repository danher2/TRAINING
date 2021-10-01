import React from 'react';
import { mount } from 'enzyme';
import { AppRouter } from '../../routers/AppRouter';
import { AuthContext } from '../../auth/AuthContext';

describe('Pruebas en <AppRouter />', () => {
    // este es el context que necesito que mi AppRouter tenga acceso
    const contextValue = {
        dispatch: jest.fn(), //la accion
        user: {                // el usuario con el logged false
            logged: false
        }
    }


    test('debe de mostrar login si no está autenticado', () => {
        //usamos mount para que renderice Tanto AuthContext.Provider como AppRouter
        const wrapper = mount(
            <AuthContext.Provider value={ contextValue }> {/* Simulamos lo mismo, hacemos que provea el contexto a nuestro AppRouter */}
            <AppRouter />
            </AuthContext.Provider>
        );

        //solo hacemos el snapshot
        expect( wrapper ).toMatchSnapshot();
        
    });


    test('debe de mostrar el componente marvel si está autenticado', () => {
        
    // este es el context que necesito que mi AppRouter tenga acceso
        const contextValue = {
            dispatch: jest.fn(),
            user: {
                logged: true, //esta autenticado
                name: 'Juan'
            }
        }
        
        //usamos mount para que renderice Tanto AuthContext.Provider como AppRouter
        const wrapper = mount(
            <AuthContext.Provider value={ contextValue }>
                <AppRouter />
            </AuthContext.Provider>
        );

        //esperamos que exista el navbar por clase y si es asi esta autenticado 
        expect( wrapper.find('.navbar').exists() ).toBe(true);
        

    })
    
    

})
