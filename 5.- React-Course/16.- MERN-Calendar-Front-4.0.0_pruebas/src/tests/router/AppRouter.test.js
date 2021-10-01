
//ESCENARIO PARA MIS PRUEVAS, ESTA SERIE DE IMPORTACIONES ES EL CONTEXTO O EL AMBIENTE QUE TENGO QUE TENER
// PARA QUE MIS PRUEBAS MOKEEN LAS FUNCIONES CORRESPONDIENTES Y PUEDAN EJECUTARSE
// SIEMPRE SE IMPORTA LA FUNCION QUE VOY A PROBAR DEL ORIGINAL

import React from 'react'; // para renderizar
import { mount } from 'enzyme'; // para hacer el wraper y mandar informacion
import { Provider } from 'react-redux'; // lo que manda la informacion a los componentes hijos

// para simular la configuracion del store
import configureStore from 'redux-mock-store';
import thunk from 'redux-thunk';

// para mockear funciones
import '@testing-library/jest-dom';
import { AppRouter } from '../../router/AppRouter';


const middlewares = [ thunk ]; // se toma el thuink
const mockStore = configureStore( middlewares ); // se configura el store con el thunk


// store.dispatch = jest.fn();


describe('Pruebas en <AppRouter />', () => {

    test('debe de mostrar el espere...', () => {
        // fijamos el checking del inicalStare en true
        const initState = {
            auth: {
                checking: true
            }
        };
// se manda al store
        const store = mockStore( initState );

        // se manda el store al approuter
        const wrapper = mount(
            <Provider store={ store } >
                <AppRouter />
            </Provider>
        );

        // expect( wrapper ).toMatchSnapshot();
        // y se espera que el h5 sea true teniendo el Espere... activado debido al cheking del inicialState en true
        expect( wrapper.find('h5').exists() ).toBe(true);
        
    })
    

    test('debe de mostrar la ruta pública', () => {
        

        // mandamos el inicialstate con el usuario nulo
        const initState = {
            auth: {
                checking: false,
                uid: null
            }
        };
        
        // enviamos el inicialstate al store
        const store = mockStore( initState );

        // envolvemos nuestro AppRouter
        const wrapper = mount(
            <Provider store={ store } >  {/*  proveemos el store al nivel del AppRouter*/} 
               <AppRouter />
            </Provider>
        );

        // hacemos el snapshot
        expect( wrapper ).toMatchSnapshot();
        // espera que haya una clase llamada login-container
        expect( wrapper.find('.login-container').exists() ).toBe(true);
        
    })

    test('debe de mostrar la ruta privada', () => {
        
        const initState = {
            calendar: {
                events: []
            },
            ui: {
                modalOpen: false
            },
            auth: {
                checking: false,
                uid: '123',
                name: 'Juan Carlos'
            }
        };
        
        const store = mockStore( initState );

        const wrapper = mount(
            <Provider store={ store } >
                <AppRouter />
            </Provider>
        );

        expect( wrapper ).toMatchSnapshot();
        expect( wrapper.find('.calendar-screen').exists() ).toBe(true);
        
    })
    
})
