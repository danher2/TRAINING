import { shallow } from 'enzyme'
import React from 'react'

import { AddCategory } from "../../components/AddCategory"



describe('Pruebas en <AddCategory/>',()=>{
    const setCategories = jest.fn();
    let wrapper = shallow(<AddCategory setCategories = {setCategories}/>);


    beforeEach(()=>{
        jest.clearAllMocks();
        wrapper = shallow(<AddCategory setCategories = {setCategories}/>);


    })

  test('Debe mostrarse correctamente ', () => {
        expect(wrapper).toMatchSnapshot();

   })

   test('debe de cambiar la caja de texto', ()=>{

        const input  = wrapper.find('input');
        const value = 'Hola Mundo'; // valor para mandar a la caja de texto

        input.simulate('change',{target: {value}});

        expect(wrapper.find('p').text().trim()).toBe(value);


   })


   test('no debe de postear la informacion con submit', () => {
        wrapper.find('form').simulate('submit',{preventDefault: ()=>{} });

        expect(setCategories).not.toHaveBeenCalled();
        

   })


   test('Debe de llamar el setCategories y limpiar la caja de texto ', () => {
    const value = 'Hola mundo';  // el valor utilizado para pruebas
    
    //1. simular el inputChange
    wrapper.find('input').simulate('change', {target: {value}}) //mandamos el argumento que se manda en la funcion un objeto dentro de otro objeto
    //2. Simular el submit
    wrapper.find('form').simulate('submit', {preventDefault: ()=>{} }) //mandamos el argumento que se manda en la funcion un objeto dentro de otro objeto

    //3. SetCategories debe ser de haber llamado
    expect(setCategories).toHaveBeenCalled();// verificamos que se haya llamado por lo menos una vez
    expect(setCategories).toHaveBeenCalledTimes(1);// verificamos que se haya llamado por lo menos una vez
    expect(setCategories).toHaveBeenCalledWith(expect.any(Function));// verificamos que se haya llamado por lo menos una vez



    //4. el valor del input debe estar ''
    expect(wrapper.find('input').prop('value')).toBe('');

   })
   
   


})