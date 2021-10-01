import React from 'react';
import { shallow } from "enzyme"
import { TodoListItem } from "../../../components/08-useReducer/TodoListItem"
import { demoTodos } from '../../fixtures/demoTodos';


describe('Pruebas en TodoListItem', () => {

    const handleDelete = jest.fn();
    const handleToggle = jest.fn();

    const wrapper = shallow( <TodoListItem 
        todo = { demoTodos[0]}
        index = {0}
        //se simula la funcion con jest.fn() en la parte de arriba
        handleDelete = {handleDelete}
        handleToggle = {handleToggle}
    
    />)

    test('debe de mostrarse correctamente ', () => {
        //snapshot
           expect(wrapper).toMatchSnapshot();
    })



    test(' debe llamar la funcion handleDelete ', () => {
        //jest.fn??
        //toHaveBeenCalled
        //toHaveBeenCalledWith

        //busco el boton y simulo un click que es el que llama a la funcion handleDelete
        wrapper.find('button').simulate('click');
        //esperamos que la funcion handleDelete me devuele el id del primer objeto de demoTodos
        expect(handleDelete).toHaveBeenCalledWith(demoTodos[0].id);
    })
    
    
    
    test('debe de llamar la funcion handleToggle ', () => {
        
        //jest.fn??
        //toHaveBeenCalled
        //toHaveBeenCalledWith
        
        //busco el boton y simulo un click que es el que llama a la funcion handleDelete
        wrapper.find('p').simulate('click');
        //esperamos que la funcion handleDelete me devuele el id del primer objeto de demoTodos
        expect(handleToggle).toHaveBeenCalledWith(demoTodos[0].id);
    })
    
    
    test('debe mostrar el texto correctamente ', () => {
        //primero ubica el parrafo donde se encuentra el texto
        const p = wrapper.find('p');
        //esperamos que el texto del parrafo sin espacios sea igual a 
        expect( p.text().trim() ).toBe(`1. ${ demoTodos[0].desc}`)
        

    })
    
    
    test('debe tener la clase complete si el TODO.done = true ', () => {
            //extraemos nuestro primero objeto de demoTodos
            const todo = demoTodos[0];
            todo.done = true;

            const wrapper = shallow( 
                <TodoListItem 
                    todo = {todo}
                />)
                //verificamos que p tenga la clase complete
                expect(wrapper.find('p').hasClass('complete')).toBe(true);

    })

})