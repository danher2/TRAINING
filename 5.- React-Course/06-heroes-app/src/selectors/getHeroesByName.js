import { heroes } from '../data/heroes';


export const getHeroesByName = ( name = '' ) => {

// si no se escribe nada que regrese un string vacio
    if ( name === '' ) {
        return [];
    }

    //indistinto de minusculas y mayusculas
    name = name.toLocaleLowerCase();
    //buscar heroes por el name que estoy recibiendo
    return heroes.filter( hero => hero.superhero.toLocaleLowerCase().includes( name )  );

}