import { mount } from 'enzyme';
import React from 'react'
import { LoginScreen } from '../../../components/09-useContext/LoginScreen';
import { UserContext } from '../../../components/09-useContext/UserContext';

describe('Pruebas en LoginScreen', () => {

    const setuser = jest.fn();

        //wrapper con mount
    const wrapper = mount(
        <UserContext.Provider value={{ setuser }}>
            <LoginScreen />
        </UserContext.Provider>);

    test('Debe de mostrarse correctamente ', () => {
        //snapshot
        expect(wrapper).toMatchSnapshot();
    })


    test('Debe de ejecutar el setuser con el argumento esperado', () => {
        
        //se puede hacer tmb como property       //el parentesis quiere decir que se manda a llamar la funcion que dispara el eonclick
        // wrapper.find('button').prop('onClick')();

         //busco el boton y simulo un click que es el que llama a la funcion setuser
        wrapper.find('button').simulate('click');
        //esperamos que la funcion setuser me devuele el objeto
        expect(setuser).toHaveBeenCalledWith({
            id: 123,
            name: 'Daniel'

        });
    })
    
    
})