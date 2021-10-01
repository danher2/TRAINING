import React, { useMemo } from 'react';
import queryString from 'query-string';
import { HeroCard } from '../heroes/HeroCard';
import { useForm } from '../../hooks/useForm';
import { useLocation } from 'react-router-dom';
import { getHeroesByName } from '../../selectors/getHeroesByName';

export const SearchScreen = ({ history }) => {

    const location = useLocation();
    //desestructuramos el query igual a un string vacio
    const { q = '' } = queryString.parse( location.search );

    //
    const [ formValues, handleInputChange ] = useForm({searchText: q});
    const { searchText } = formValues;
    
    //se usa memo para que no dispare la busqueda cada que se hahga una busqueda en el sercher, cada ves que la dependencia q de query cambie
    const heroesFiltered = useMemo(() => getHeroesByName( q ), [q])
    // const heroesFiltered =  getHeroesByName( q );


    const handleSearch = (e) => {
        //para que no haga el refresh en el formulario
        e.preventDefault();
        //para inyectar las qwerys en las rutas
        history.push(`?q=${ searchText }`);
    }

    return (
        <div>
            <h1>Search Screen</h1>
            <hr />
            
            <div className="row">
                
                <div className="col-5">
                    <h4> Search Form </h4>
                    <hr />

                    <form onSubmit={ handleSearch }>
                        <input 
                            type="text"
                            placeholder="Find your hero"
                            className="form-control"
                            name="searchText"
                            autoComplete="off"
                            value={ searchText }
                            onChange={ handleInputChange }
                        />

                        <button
                            type="submit"
                            className="btn m-1 btn-block btn-outline-primary"
                        >Search...</button>
                    </form>


                </div>


                <div className="col-7">

                    <h4> Results </h4>
                    <hr />
                    {/* colocamos los resultados del arreglo */}
                    { 
                        // si el query es un string vacio significa que la persona no ha buscado nada
                        (q ==='') 
                            &&   // entonces...
                            <div className="alert alert-info">
                                Search a hero
                            </div>
                    }

                    { 
                        (q !=='' && heroesFiltered.length === 0 ) 
                            && 
                            <div className="alert alert-danger">
                                There is no a hero with { q }
                            </div>
                    }

                    {
                        heroesFiltered.map( hero => (
                            <HeroCard 
                                key={ hero.id }
                                { ...hero }
                            />
                        ))
                    }

                </div>

            </div>


        </div>
    )
}
