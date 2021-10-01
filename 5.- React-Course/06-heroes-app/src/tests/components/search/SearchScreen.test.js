import React from 'react';
import { mount } from 'enzyme';
import { MemoryRouter, Route } from 'react-router-dom';
import { SearchScreen } from '../../../components/search/SearchScreen';


describe('Pruebas en <SearchScreen />', () => {

    test('debe de mostrarse correctamente con valores por defecto', () => {
        
        const wrapper = mount(
            <MemoryRouter initialEntries={['/search']}>{/* Necesitamos MemoryROuter porque usamos ROute  */}
                <Route path="/search" component={ SearchScreen } />{/* Route envia la ruta con la que trabajaremos y muesra el componente de esa ruta trabajamos con rutas al buscar en search */}
                </MemoryRouter>
        );

        //creamos el snapshot
        expect( wrapper ).toMatchSnapshot();

        //el texdto del elemento que tenga el className .alert-info sea  'Search a hero' 
        expect( wrapper.find('.alert-info').text().trim() ).toBe('Search a hero');

    })

    test('debe de mostrar a Batman y el input con el valor del queryString', () => {
        
        const wrapper = mount(
            <MemoryRouter initialEntries={['/search?q=batman']}> {/* simple array de locations en el history stack en este caso solo envimamos */}
                  <Route path="/search" component={ SearchScreen } />
            </MemoryRouter>
        );

        //esperaria que la property value que sea batman
        expect( wrapper.find('input').prop('value') ).toBe('batman');
        expect( wrapper ).toMatchSnapshot();

    })

    
    test('debe de mostrar un error si no se encuentra el Hero', () => {
        
        const wrapper = mount(
            <MemoryRouter initialEntries={['/search?q=batman123']}>
                <Route path="/search" component={ SearchScreen } />
            </MemoryRouter>
        );

        expect( wrapper.find('.alert-danger').text().trim() ).toBe(`There is no a hero with batman123`);
        expect( wrapper ).toMatchSnapshot();

    })
    
    
    test('debe de llamar el push del history', () => {

        //simulamos la funcion push del hisroy que usaremos en submit del form 
        const history = {
            push: jest.fn()
        };

        const wrapper = mount(
            <MemoryRouter initialEntries={['/search?q=batman123']}>{/* se manda a llamar esta ruta en el history*/}
                <Route 
                    path="/search" 
                    component={ () => <SearchScreen history={ history } /> } // llamamos a componente searchScreen con el path '/search y mando el hisroty'
                />
            </MemoryRouter>
        );

        //simulo el cambio en la caja de texto con el change (onChange) y le mando el evento que es el objeto target con  el name y value
        wrapper.find('input').simulate('change', {
            target: {
                name: 'searchText',
                value: 'batman'
            }
        });

        //simulamos el submit del formulario y mandamos el evento que tendra el preventDefault
        wrapper.find('form').prop('onSubmit')({
            preventDefault(){} //el evento que se manda
        });

        //esperaria que el push del history haya sido llamado con ?q=batman
        expect( history.push ).toHaveBeenCalledWith(`?q=batman`);

        
    })
    

    

    
})
