import React, { useMemo } from 'react';
import { useParams, Redirect } from 'react-router-dom';
import { getHeroById } from '../../selectors/getHeroById';
// import batman from '../../assets/heroes/dc-batman.jpg'; estatico


const heroImages = require.context('../../assets/heroes', true);


export const HeroScreen = ({ history }) => {

    //va a extraer los paramtros que se encuentran en los props para  que vayan por el url
    const { heroeId } = useParams();

    //si el id no cambia  entonces Memorizar estados si las dependencias se mantienen igual
                            //    funcion              las dependencias el input ose cuando tiene que memorizar eso                     
    const hero = useMemo(() => getHeroById( heroeId ), [ heroeId ]);


    if ( !hero ) { // si el useMemo

        // lo redireccionamos a la pagina de marvel
        return <Redirect to="/" />;
    }


    // metodo del boton Return
    const handleReturn = () => {
        //Tarea regresar a la pagina anterior, history es una property del HeroScreen

        if (history.length <= 2) { //si tiene menos de dos o dos registros de historia
            history.push('/'); //regresa a la ruta principal (de marvel)
        }else{

            history.goBack(); //simplemente que regrese atras
        }

    }

    //desestructuro el objeto hero
    const {
        superhero,
        publisher,
        alter_ego,
        first_appearance,
        characters,
    } = hero;
    
    return (
        <div className="row mt-5">
            <div className="col-4">
               {/* el heroeId */}
                <img 
                     // src={ `../assets/heroes/${ heroeId }.jpg` } // desde public/assets
                    // src={ batman } // import
                    src={ heroImages(`./${ heroeId }.jpg`) }
                    // lo que se muestra si no se muestra la imagen de linea 49 (el nombre)
                    alt={ superhero }
                    className="img-thumbnail animate__animated animate__fadeInLeft"
                />
            </div>

            <div className="col-8 animate__animated animate__fadeIn">
                <h3> { superhero } </h3>
                {/* ponemos en un order list la informacion */}
                <ul className="list-group list-group-flush">
                    <li className="list-group-item"> <b> Alter ego: </b> { alter_ego } </li>
                    <li className="list-group-item"> <b> Publisher: </b> { publisher } </li>
                    <li className="list-group-item"> <b> First appearance: </b> { first_appearance } </li>
                </ul>

                <h5> Characters </h5>
                {/* parrafo con los caracteres */}
                <p> { characters } </p>

                <button 
                    className="btn btn-outline-info"
                    onClick={ handleReturn }
                >
                    Return
                </button>

            </div>

        </div>
    )
}
