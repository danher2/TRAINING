import { any } from 'bluebird';
import { shallow } from 'enzyme';
import React from 'react';
import { TodoList } from '../../../components/08-useReducer/TodoList';
import { demoTodos } from '../../fixtures/demoTodos';

describe('Pruebas en TodoList', () => {

    // simula el comportamiento de la funcion
    const handleDelete = jest.fn();
    const handleToggle = jest.fn();



    const wrapper = shallow(
        <TodoList
            todos={demoTodos}
            handleDelete={handleDelete}
            handleToggle={handleToggle}
        />)



    test('debe de mostrarse correctamente', () => {

        expect(wrapper).toMatchSnapshot();


    })


    test('debe de tener el numero de elementos de TodoListItems ', () => {
        console.log(wrapper.find('TodoListItem').length);
        expect(wrapper.find('TodoListItem').length).toBe(demoTodos.length);
        
        //para ver las propiedades del elemento 0 del arreglo que regresa el componente TodoListItem
        // console.log(wrapper.find('TodoListItem').at(0).props());
        
        
        //para ver solo una propiedad del elemento 0 del arreglo que regresa el componente TodoListItem es con prop
        // console.log(wrapper.find('TodoListItem').at(0).prop('handleDelete'));
        
        //espera cualquier funcion
        expect(wrapper.find('TodoListItem').at(0).prop('handleDelete')).toEqual(expect.any(Function));
    
    })
    


})