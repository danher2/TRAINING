import { mount, shallow } from "enzyme"
import { TodoApp } from "../../../components/08-useReducer/TodoApp"
import React from 'react'
import { demoTodos } from '../../fixtures/demoTodos';
import { act } from "@testing-library/react";


describe('Pruebas en TodoApp', () => {

const wrapper = shallow( <TodoApp />)
Storage.prototype.setItem = jest.fn();


test('Debe mostrarse correctamente ', () => {
    
    expect(wrapper).toMatchSnapshot();
})

test(' debe de agregar un todo ', () => {
    
    //mount direferencia en el nivel en el cual esta renderizada la app
    //con mount se monta todo porque necesitamos ver el localStorage
    //cuando necesitas probar toda la app en contexto en general usas mount
    //shallow es para el componente namas y mount para el componente y sus hijos etc
    const wrapper = mount( <TodoApp/> );
   
   act(() => { 
       
       wrapper.find('TodoAdd').prop('handleAddTodo')(demoTodos[0])
       wrapper.find('TodoAdd').prop('handleAddTodo')(demoTodos[1])
    });
    
    expect(wrapper.find('h1').text().trim() ).toBe('Todo App (2)');
    expect(localStorage.setItem).toHaveBeenCalledTimes(2);
    //min 5:27 video 157
    
})

test('debe de eliminar un todo', () => {
    
    //primero agregamos uno
    wrapper.find('TodoAdd').prop('handleAddTodo')(demoTodos[0]);
    //ahora lo eliminamos por el id
    wrapper.find('TodoList').prop('handleDelete')(demoTodos[0].id);
    //esperamos 0 elementos
    expect(wrapper.find('h1').text().trim() ).toBe('Todo App (0)');

})






})