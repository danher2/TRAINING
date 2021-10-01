import { render } from "@testing-library/react";
import '@testing-library/jest-dom';
import React from "react";
import PrimeraApp from "../PrimerApp";
import { shallow } from 'enzyme';

describe('Pruebas en componente <PrimerApp />', ()=>{

    // test('debe retornar el mensaje Hola soy Goku', ()=>{

    //     //given
    //     const saludo = 'Hola soy goku';
    //     const {getByText}= render(<PrimeraApp  saludo = {saludo}/>) // funcion que recibira un componente que queremos renderizar
        
    //     //when 


    //     //then
    //     expect(getByText(saludo)).toBeInTheDocument();


    // })

    test('debe de mostrar el compomente <PrimerApp /> correctamente',()=>{

        //given
        const saludo = 'Hola soy Goku';
        const wrapper = shallow(<PrimeraApp saludo= {saludo} />);

        //esperariamos que este componente se renderize de la forma correcta
        expect(wrapper).toMatchSnapshot();
    })




    test('debe de mostrar el subtitulo mostrado por props',()=>{

        //given
        const saludo = 'Hola soy Goku';
        const subtitulo = 'Soy un subtitulo';

        const wrapper = shallow(<PrimeraApp 
            saludo= {saludo} 
            subtitulo = {subtitulo}
            />
            );

            const textoParrafo = wrapper.find('p').text(subtitulo);
            console.log(textoParrafo);
        //esperariamos que este componente se renderize de la forma correcta
      expect(textoParrafo).toBe(subtitulo);


    })

})