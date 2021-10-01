import React from 'react'
import { Link } from 'react-router-dom';

export const HeroCard = ({
        id,
        superhero, 
        publisher, 
        alter_ego,
        first_appearance,
        characters
}) => {

    
    return (
        <div className="col">
    <div className="card h-100">
                <div className="col-md-4">
                    <img src={ `./assets/heroes/${ id }.jpg` } className="card-img" alt={ superhero } />
                </div>
                <div className="col-md-8">
                    
                    <div className="card-body">
                        <h5 className="card-title"> { superhero } </h5>
                        {/* parrafo  que muestra el alter_ego del heroe*/}
                        <p className="card-text"> { alter_ego} </p>

                        {
                            //si el alter_ego es diferente de los caracter
                            ( alter_ego !== characters ) 
                            //quierp que ahi se rendeerize caracteres dentro de otro parrafo
                                && <p className="card-text"> { characters } </p>
                        }

                        <p className="card-text">
                            <small className="text-muted"> { first_appearance } </small>
                        </p>

                        {/* para hacer un enlace redirige a una ruta que no exista, se manda el id del heroe */}
                        <Link to={ `./hero/${ id }` }>
                            Más...
                        </Link>

                    </div>

                </div>
            </div>
        </div>
    )
}
