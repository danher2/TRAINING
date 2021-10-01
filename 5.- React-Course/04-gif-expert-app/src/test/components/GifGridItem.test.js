import React from 'react'
import { shallow } from "enzyme"
import { GifGridItem } from "../../components/GifGridItem"



describe('Prueba en <GifGridItem />',()=>{

    const title = 'Titulo';
    const url = 'http://www.google.com';
    const wrapper = shallow(<GifGridItem
        title = {title}
        url = {url}
/>)



    test('debe mostrar el componente corractamente ', () => {
        
        
        expect(wrapper).toMatchSnapshot();

    })


    test('Debe tener un parrafo con el titulo ', () => {
        

        const parrafo = wrapper.find('p');
        expect(parrafo.text().trim() ).toBe(title);


    })
    
    test('Debe obtener la imagen igual  al url y alt de los props', () => {

        const img = wrapper.find('img');
        console.log(img.props().src);
    // console.log(img.props('src'));

    expect(img.props().src).toBe(url)
    expect(img.props().alt).toBe(title)

        
    })


    test('debe tener animate__rubberBand ', () => {

        const div =  wrapper.find('div');
        console.log(div.props().className);
        const className = div.props().className;

        expect(className.includes('animate__rubberBand')).toBe(true)


    })
    
    

})