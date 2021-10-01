import React from 'react'; // para renderizar
import { mount } from 'enzyme'; // para hacer el wrapper a todos los hijos
import { Provider } from 'react-redux'; // para proveer el store en el wrapper

// configuracion del store
import configureStore from 'redux-mock-store';
import thunk from 'redux-thunk';


import { act } from '@testing-library/react';

import '@testing-library/jest-dom';

//importamos nuestros componentes 
import { CalendarScreen } from '../../../components/calendar/CalendarScreen';
import { messages } from '../../../helpers/calendar-messages-es'; // los atributos de mi  componente calendar
import { types } from '../../../types/types';
import { eventSetActive } from '../../../actions/events';


// mockeamos dos funciones  = eventSetActive y eventStartLoading
jest.mock('../../../actions/events', () => ({
    eventSetActive: jest.fn(),
    eventStartLoading: jest.fn(),
}))

//mockeamos la funcion de setItem del storage
Storage.prototype.setItem = jest.fn();

const middlewares = [ thunk ]; // sacamos el arreglo del think
const mockStore = configureStore( middlewares ); // mockeamos el store


// creamos el stado inicial de los eventos (arreglo vacio), con un usuario y el modal en falso, no abierto
const initState = {
    calendar: {
        events: []
    },
    auth: {
        uid: '123',
        name: 'Fernando'
    },
    ui: {
        openModal: false
    }
};

// asignamos el estado inicial al store
const store = mockStore( initState );
store.dispatch = jest.fn(); // mockeamos la funcion dispatch


// envolvemos el calendar y antes del pasamos el store  para todos sus hijos
const wrapper = mount(
    <Provider store={ store } >
        <CalendarScreen />
    </Provider>
)



describe('Pruebas en <CalendarScreen />', () => {
    
    test('debe de mostrarse correctamente', () => {
        // se imprime el snapshot
        expect( wrapper ).toMatchSnapshot();

    });

    test('pruebas con las interacciones del calendario', () => {
        
        // encuenten primero el componente calendar <Calendar />
        const calendar = wrapper.find('Calendar');


        const calendarMessages = calendar.prop('messages'); // extrameos los atributos mandados en el componente calendar en CalendarScreen
        // esperamos que los atributos mandados en el componente CalendarScreen sean los mismo que messages (obtenidos de los helpers)
        expect( calendarMessages ).toEqual( messages )


        //--funciones en los atributos del componente <Calendar />--//

        // se llame el funcion  onDoubleClickEvent
        calendar.prop('onDoubleClickEvent')();
        // el dispatch se envia con el type (que es el argumento
        expect( store.dispatch ).toHaveBeenCalledWith({ type: types.uiOpenModal })
        

        // que al llamar la funcion onSelectevent
        calendar.prop('onSelectEvent')({ start: 'Hola' });

        // esperamos que eventSetActive fue llamado con  ese argumento que es ese objeto 
        expect( eventSetActive ).toHaveBeenCalledWith({ start: 'Hola' }) // valor el evento que dispara

// el act significa que Envuelve cualquier código que renderice y desencadene actualizaciones de sus componentes en llamadas a act().
//Garantiza que el comportamiento en sus pruebas coincida más con lo que ocurre en el navegador al ejecutar los useEffects pendientes antes de regresar. Esto también reduce la cantidad de re-renders realizados.

        act(() => {

            // la propiedad onview y week del componente calendar
            calendar.prop('onView')('week');

            //esperamos que el localStorage haya sido llamado con los argumentos lastView y week
            expect( localStorage.setItem ).toHaveBeenCalledWith('lastView','week');
        })

    })
    
    

})
