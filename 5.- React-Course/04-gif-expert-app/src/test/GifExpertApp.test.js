import React from 'react'
import {GifExpertApp} from '../GifExpertApp';
import { shallow } from 'enzyme';




describe('Pruebas en gifGrid',()=>{




test('debe mostrarse correctamente', () => {
    
    const wrapper = shallow(<GifExpertApp/>)
    expect(wrapper).toMatchSnapshot(); // to make sure your UI does not change unexpectedly.
    
    
})


test('debe mostrar una lista de categorias ', () => {

    const categories = ['One punch', 'Dragon Ball'];
    const wrapper = shallow(<GifExpertApp defaultCategories = { categories }/>);
    expect( wrapper ).toMatchSnapshot();
    console.log(wrapper.find('GifGrid').length)

    expect( wrapper.find('GifGrid').length ).toBe(categories.length)
    
})



})
