import React from 'react';
import { mount } from 'enzyme';
import { AuthContext } from '../../auth/AuthContext';
import { DashboardRoutes } from '../../routers/DashboardRoutes';
import { MemoryRouter } from 'react-router-dom';


describe('Pruebas en <DashboardRoutes />', () => {
    

    //creamos el contexto para que sera provisto por  por AuthCOntext.Provider
    const contextValue = {
        dispatch: jest.fn(),
        user: {
            logged: true,
            name: 'Juanito'
        }
    }


    test('debe mostrarse correctamente', () => {
        
        const wrapper = mount(
            <AuthContext.Provider value={ contextValue }>
                <MemoryRouter>
                    {/* incorporamos en memoryRouter DashboardRoute porque estamos haciendo pruebas con Rutas  */}
                    <DashboardRoutes />
                </MemoryRouter>
            </AuthContext.Provider>
        );

        //hacemos snapshot
        expect( wrapper ).toMatchSnapshot();
        //esperamos que la clase .text-info tenga 'Juanito'
        expect( wrapper.find('.text-info').text().trim() ).toBe('Juanito');

    })
    

})
