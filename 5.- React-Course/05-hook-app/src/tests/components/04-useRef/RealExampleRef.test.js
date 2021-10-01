import { shallow } from 'enzyme';
import React from 'react';
import { RealExampleRef } from '../../../components/04-useRef/RealExampleRef';

describe('Pruebas en <RealExampleRef />', () => {
    const wrapper = shallow( <RealExampleRef />);


test('debe mostrarse correctamente (snapshot)', () => {

    expect(wrapper).toMatchSnapshot();
    expect(wrapper.find('MultipleCustomHooks').exists() ).toBe(false);
    
    
    
})


test('debe mostrar el componente <MultipleCustomHooks />', () => {
    
    wrapper.find('button').simulate('click');
    
    expect(wrapper.find('MultipleCustomHooks').exists() ).toBe(true);
})



})