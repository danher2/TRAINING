// importaciones necesarias para la creacion del escenario o contexto de mis pruebas

import React from 'react';
import { mount } from 'enzyme';
import { Provider } from 'react-redux';

import configureStore from 'redux-mock-store'; // para configurar el store simulado
import thunk from 'redux-thunk'; // para hacer los dispatch al store
import moment from 'moment'; // para trabajar con fechas

import '@testing-library/jest-dom'; // para mockear funciones
import { CalendarModal } from '../../../components/calendar/CalendarModal'; // importamos nuestro componente a testear
// importamos nuestras funciones de eventos para despues mockearlas
import { eventStartUpdate, eventClearActiveEvent, eventStartAddNew } from '../../../actions/events';
import { act } from '@testing-library/react';
import Swal from 'sweetalert2';


// mockeamos el sweet alert
jest.mock('sweetalert2', () => ({
    fire: jest.fn(),
}))


// funciones de eventos que tenemos que mockear
jest.mock('../../../actions/events', () => ({
    eventStartUpdate: jest.fn(),
    eventClearActiveEvent: jest.fn(),
    eventStartAddNew: jest.fn()
}))

const middlewares = [ thunk ]; // guardamos el arreglo del thunk
const mockStore = configureStore( middlewares ); // lo configuramos en el mockStore

// se establece la hora mas una hora
const now = moment().minutes(0).seconds(0).add(1,'hours'); // 3:00:00
const nowPlus1 = now.clone().add(1, 'hours');


//  iniciamos el state del store engeneral , del calendar, auth y uid
const initState = {
    calendar: {
        events: [],
        activeEvent: {
            title: 'Hola Mundo',
            notes: 'Algunas notas',
            start: now.toDate(),
            end: nowPlus1.toDate()
        }
    },
    auth: {
        uid: '123',
        name: 'Fernando'
    },
    ui: {
        modalOpen: true
    }
};

// se fija el state en el mockStore
const store = mockStore( initState );
store.dispatch = jest.fn();


// se en vuelve el CalendarModal  provisto por el store
const wrapper = mount(
    <Provider store={ store } >
        <CalendarModal />
    </Provider>
);


describe('Pruebas en <CalendarModal />', () => {

    // en cada test limpiar los mocks
    beforeEach(() => {
        jest.clearAllMocks();
    })


    
    test('debe de mostrar el modal', () => {
        // esperamos encuentra el modal  en la propiedad isOpen si esta en true
        expect( wrapper.find('Modal').prop('isOpen') ).toBe(true);

    });

    test('debe de llamar la acción de actualizar y cerrar modal', () => {
        //simula el submit del form (renderizacion, por eso se importa el react)
        wrapper.find('form').simulate('submit', {
            preventDefault(){} // evitar el refres 
        });

        // se espera que el  eventStartUpdate sea llamado con  el activeEvent estado del calendae
        expect( eventStartUpdate ).toHaveBeenCalledWith( initState.calendar.activeEvent );
        // se espera que se llame el evento eventClearActiveEvent
        expect( eventClearActiveEvent ).toHaveBeenCalled();

    })
    
    test('debe de mostrar error si falta el titulo', () => {
// simulamos el submit del modal
        wrapper.find('form').simulate('submit', {
            preventDefault(){}
        });

        // esperamos que el imput titulo tenga la clase is-invalid
        expect( wrapper.find('input[name="title"]').hasClass('is-invalid') ).toBe(true);
        
    })

    test('debe de crear un nuevo evento', () => {
// se crea  el estado inicial
        const initState = {
            calendar: {
                events: [],
                activeEvent: null
            },
            auth: {
                uid: '123',
                name: 'Fernando'
            },
            ui: {
                modalOpen: true
            }
        };
        
        // se manda ese estado al store
        const store = mockStore( initState );
        store.dispatch = jest.fn(); // se simula la funcion dispatch
        
        // se envuelve el CalendarModal provisto por el store
        const wrapper = mount(
            <Provider store={ store } >
                <CalendarModal />
            </Provider>
        );
        

        // se simula el llenado del input title con Hola pruebas
        wrapper.find('input[name="title"]').simulate('change',{
            target: {
                name: 'title',
                value: 'Hola pruebas'
            }
        });
        
        // se simula el submit del form
        wrapper.find('form').simulate('submit', {
            preventDefault(){}
        });

        // se espera que el evento eventStartAddNew sea llamado con el nuevo evento
        expect( eventStartAddNew ).toHaveBeenCalledWith({
            end: expect.anything(), // espera lo que sea
            start: expect.anything(),
            title:'Hola pruebas', // espera el tituloo Hola pruebas que le pusimos arriba
            notes: ''
        });

        // al finalizar se espera que eventClearActiveEvent haya sido llamado
        expect( eventClearActiveEvent ).toHaveBeenCalled();

    })
    
    
    test('debe de validar las fechas', () => {

        // se simula el llenado del input title
        wrapper.find('input[name="title"]').simulate('change',{
            target: {
                name: 'title',
                value: 'Hola pruebas'
            }
        });

        // se establece la fecha de hoy
        const hoy = new Date();

        act(()=> { // de react testing library

            //validamos que la primera fecha (start sea con la fecha del dia de hoy)
            // el at(1) significa la segunda posicion del DateTimePicker, osea que hay dos DateTimePicker y la posicion 1
            // hace referencia al segundo DateTimePicker creado  que es la fecha final o end
            // y la validacion dice que la fecha finalizacion tiene que ser mayor a la fecha de inicio y la fecha de inicio
            // es la de hoy, por tanto no puede ser la fecha de hoy y devolvera error, el cual llamara al swal alert
            wrapper.find('DateTimePicker').at(1).prop('onChange')(hoy);
        })

        // simulamos el submit del modal
        wrapper.find('form').simulate('submit', {
            preventDefault(){}
        });

// se espera el swal por error en la fecha
        expect( Swal.fire ).toHaveBeenCalledWith("Error", "La fecha fin debe de ser mayor a la fecha de inicio", "error");

    })
    


})
