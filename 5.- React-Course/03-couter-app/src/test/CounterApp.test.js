import { render } from "@testing-library/react";
import '@testing-library/jest-dom';
import React from "react";
import CounterApp from "../CounterApp";
import { shallow } from 'enzyme';

describe('debe mostrar <CounterApp/> correctamente (hacer match con snapshot) y sus valores por defecto', ()=>{

    let wrapper = shallow(<CounterApp />);

    beforeEach(()=>{
        console.log('se ejecuta antes de cada test')
         wrapper = shallow(<CounterApp />);


    })


    test('mostrar <CounterApp/> correctamente (hacer match con snapshot)',()=>{
            expect(wrapper).toMatchSnapshot();

    })


    test(' mostrar el valor por defecto de 100',()=>{

        const wrapper = shallow(<CounterApp value = {100} />);
        const wrapperCounter = wrapper.find('h2').text().trim();
        console.log(wrapperCounter);
        expect(wrapperCounter).toBe('100')

})

    test('debe de incrementar con el boton de +1 ', () => {
     const bt1 =   wrapper.find('button').at(0).simulate('click');
        // console.log(bt1.html());

        const wrapperCounter = wrapper.find('h2').text().trim();
        console.log(wrapperCounter);
       
        expect(wrapperCounter).toBe('11');

    })



    test('debe de decrementar con el boton de -1 ', () => {

        
        const bt1 =   wrapper.find('button').at(2).simulate('click');
           // console.log(bt1.html());
   
           const wrapperCounter = wrapper.find('h2').text().trim();
           console.log(wrapperCounter);
          
           expect(wrapperCounter).toBe('9');
   
       })
       

       test('debe de colocar el valor por defecto con el boton btn reset', () => {

        const wrapper = shallow(<CounterApp value = {105} />);

        //simulando click en los botones
        wrapper.find('button').at(0).simulate('click'); //boton sumar
        wrapper.find('button').at(0).simulate('click');// boton sumar
        wrapper.find('button').at(1).simulate('click');// boton reset 
        const wrapperCounter = wrapper.find('h2').text().trim();
        console.log(wrapperCounter);   

        expect(wrapperCounter).toBe('105')
   
       })


})