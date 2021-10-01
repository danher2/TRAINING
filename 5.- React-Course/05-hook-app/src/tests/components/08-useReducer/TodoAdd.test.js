import { shallow } from 'enzyme'
import { ExpectationFailed } from 'http-errors';
import React from 'react'
import {TodoAdd} from '../../../components/08-useReducer/TodoAdd';


describe('Pruebas con TodoAdd', () => {
    //mockeamos la funcion que recibe elcomponente
    const handleAddTodo = jest.fn();


    const wrapper = shallow( 
    <TodoAdd 
    handleAddTodo = {handleAddTodo}
    />)
    

    test('debe de mostrarse correctamente ', () => {
        
        expect(wrapper).toMatchSnapshot();

    })


    test('no debe de llamar el handler al TODO ', () => {
        
        //encontramos la propiedad onSubmit en nuestro form del componente TodoAdd
        //esto hace referencia a la funcion  handleSubmit dentro del onSubmit del form
        const formSubmit = wrapper.find('form').prop('onSubmit');
        
        // console.log(formatSubmit);
        
        // se manda como argumento el evento que ejecuta una funcion
        formSubmit({ preventDefault(){} });
        
        // que nuestro handleAdd no se llame ninguna vez
        expect(handleAddTodo).toHaveBeenCalledTimes(0);
        
    });
    
    
    test('Debe debe llamar la funcion handleAddTodo  ', () => {
        
        const value = 'Aprender React';
        
        
        
        //encontramos la propiedad onSubmit en nuestro form del componente TodoAdd
        //esto hace referencia a la funcion  handleSubmit dentro del onSubmit del form
        wrapper.find('input').simulate('change', {
            target:{
                value,
                name: 'description'
            }
        });
        
        // console.log(formatSubmit);
        const formSubmit = wrapper.find('form').prop('onSubmit');
        
        // se manda como argumento el evento que ejecuta una funcion
        formSubmit({ preventDefault(){} });

        expect(handleAddTodo).toHaveBeenCalledTimes(1);
        //ha sido llamado y lo que esperamos en esa llamada es cualquier object
        expect(handleAddTodo).toHaveBeenCalledWith(expect.any(Object));

        //ha sido llamado y lo que esperamos en esa llamada es un objeto en especifico
        expect(handleAddTodo).toHaveBeenCalledWith({
            id: expect.any(Number),
            desc: value,
            done:false
        });

        expect(wrapper.find('input').prop('value')).toBe('');
    })
    
    
    
})




