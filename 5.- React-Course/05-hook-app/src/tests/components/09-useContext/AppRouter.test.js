import { mount } from 'enzyme'
import { ExpectationFailed } from 'http-errors';
import React from 'react'
import {AppRouter} from '../../../components/09-useContext/AppRouter';
import { UserContext } from '../../../components/09-useContext/UserContext';
 
describe('Pruebas en AppRoute',  () => {

    const user = {
        id: 1,
        name: 'daniel'
    }

    const wrapper = mount(
        //le pasamos el user entre {} para especificar que se desestructura
        <UserContext.Provider value = {{ user }} > 

            <AppRouter /> 

        </UserContext.Provider>)

    test('debe mostrarse correctamente ', () => {
        
        expect(wrapper).toMatchSnapshot();
    
    })
    

    
    
})