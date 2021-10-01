import React from 'react';
import { mount } from 'enzyme'
import { HeroScreen } from '../../../components/heroes/HeroScreen';
import { MemoryRouter, Route } from 'react-router-dom';

describe('Pruebas en <HeroScreen />', () => {

    // este histori es que el recibe HeroScreen desestructurado 
    // y ponemos tdoas sus propiedades lenght, push goback
    const history = {
        length: 10,
        push: jest.fn(),
        goBack: jest.fn(),
    }
    
    test('debe de mostrar el componente redirect si no hay argumentos en el URL', () => {
        //mount para poder uutilizar higher order components envolver o renderizar a  los hijos de los hijos tmb
        const wrapper = mount(
            <MemoryRouter initialEntries={['/hero']}> {/*un objeto con url y argumentos a enviar  */}
                <HeroScreen history={ history } />
            </MemoryRouter>
        );
            //verificar que si no existe el argumento url
            //que me muestre el componente redirect
        expect( wrapper.find('Redirect').exists() ).toBe(true);

    });

    test('debe de mostrar un hero si el parámetro existe y se encuentra', () => {
        

        const wrapper = mount(
            <MemoryRouter initialEntries={['/hero/marvel-spider']}>{/* le mandamos la ruta  */}
                <Route path="/hero/:heroeId" component={ HeroScreen } />
            </MemoryRouter>
        );

        //esperariamos qu eel elemento que tenga el className row sea true
        expect( wrapper.find('.row').exists() ).toBe(true);
        

    });

    test('debe de regresar a la pantalla anterior con PUSH', () => {

        const history = {
            length: 1,  // el lenght debe ser menor que dos para que llame al push method
            push: jest.fn(), //se mokea al metodo push y goback
            goBack: jest.fn(), //son los metodos que se llaman al dar click en el boton 
        }

        const wrapper = mount(
            <MemoryRouter initialEntries={['/hero/marvel-spider']}>
                <Route 
                    path="/hero/:heroeId" 
                    component={ () => <HeroScreen history={ history } /> } // se manda el componente por medio de una funcion para de esa forma recibir los props que le manda el Route a este componente
                />
            </MemoryRouter>
        );
        
        //hacemos el click con el boton
        wrapper.find('button').prop('onClick')();
        
        //esperamo que el push haya sido llamado con la ruta  '/'
        expect( history.push ).toHaveBeenCalledWith('/');
        //esperamos que goBack no haya sido llamado because history.lenght es menor de 2
        expect( history.goBack ).not.toHaveBeenCalled();


    });

    test('debe de regresar a la pantalla anterior GOBACK', () => {
        

        const wrapper = mount(
            <MemoryRouter initialEntries={['/hero/marvel-spider']}>
                <Route 
                    path="/hero/:heroeId" 
                    component={ () => <HeroScreen history={ history } /> }
                />
            </MemoryRouter>
        );
        
        wrapper.find('button').prop('onClick')();
        
        expect( history.push ).toHaveBeenCalledTimes(0);
        //esperamos que goBack haya sido llamado because history.lenght es mayor que 2 usamor el history de a mero arriba
        expect( history.goBack ).toHaveBeenCalled();

    })


    test('debe de llamar el redirect si el hero no existe', () => {

        const wrapper = mount(
            <MemoryRouter initialEntries={['/hero/marvel-spider123123123']}>{/* este hero no existe */}
                <Route 
                    path="/hero/:heroeId"  //Route manda la Ruta 
                    component={ () => <HeroScreen history={ history } /> }
                />
            </MemoryRouter>
        );
        //espero que el texto del wrapper sea vacio
        expect( wrapper.text() ).toBe('');
        
        
    })
    
    

    
    
    

    
})
