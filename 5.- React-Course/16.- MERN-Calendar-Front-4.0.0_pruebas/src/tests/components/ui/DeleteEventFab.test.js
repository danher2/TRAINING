import React from 'react'; // si quiero rederizar un componente ocupamos reach
import { mount } from 'enzyme';
import { Provider } from 'react-redux';

import configureStore from 'redux-mock-store';
import thunk from 'redux-thunk';

import '@testing-library/jest-dom';

import { DeleteEventFab } from '../../../components/ui/DeleteEventFab';
import { eventStartDelete } from '../../../actions/events';


//mockeamos la funcion del servicio en este caso eventStartDelete
jest.mock('../../../actions/events', () => ({
    eventStartDelete: jest.fn()
}))


// necesarios para crear el store
const middlewares = [ thunk ];
const mockStore = configureStore( middlewares );

const initState = {};
const store = mockStore( initState );
// simulamos la funcion dispatch del store
store.dispatch = jest.fn();

// lo envolvemos en un mount para el snapshot
const wrapper = mount(
    //necesitamos el store para este componente
    //provider para proveer el store porque el DeleteFab para trabajar ocupa el store
    <Provider store={ store } > 
        <DeleteEventFab />
    </Provider>
)



describe('Pruebas en <DeleteEventFab />', () => {
    

    test('debe de mostrarse correctamente', () => {
        
        expect( wrapper ).toMatchSnapshot();
    });

    test('debe de llamar el eventStartDelete al hacer click', () => {
        
        wrapper.find('button').prop('onClick')();  // al hacer click


        // se llame este evento, sin argumento 
        expect( eventStartDelete ).toHaveBeenCalled();

    })
    
    

})

