
//CLASE DE LOS EVENTOS
// EN LOS EVENTOS PRIMERO SE HACE LA PETICION AL BACKEND (FUNCION ASINCRONA)
// UNA VEZ DEVUELTA  LA RESPONSE (BODY.OK), ENTONCES SE DISPARA LA ACCION AL REDUCER PARA QUE MODIFIQUE LOS ESTADOS CORRESPONDIENTES
import Swal from 'sweetalert2';
import { types } from '../types/types';
import { fetchConToken } from '../helpers/fetch';
import { prepareEvents } from '../helpers/prepareEvents';


export const eventStartAddNew = ( event ) => {
    return async( dispatch, getState ) => { // dispatch->disparamos mediante el thunk

        const { uid, name } = getState().auth;

        try { // llaamar al helper con el endpoint
            const resp = await fetchConToken('events', event, 'POST');// peticion post
            const body = await resp.json();

            console.log(body) 

            if ( body.ok ) { // si el body seinerto en la bbdd
                event.id = body.evento.id;
                event.user = {
                    _id: uid,
                    name: name
                }
                console.log( event );
                dispatch( eventAddNew( event ) ); //se hace el dispatch del evento
            }


        } catch (error) {
            console.log(error);
        }

        

    }
}



const eventAddNew = (event) => ({
    type: types.eventAddNew,
    payload: event
});

export const eventSetActive = (event) => ({
    type: types.eventSetActive,
    payload: event
});

export const eventClearActiveEvent = () => ({ type: types.eventClearActiveEvent });


//peticion y dispato de servicio actualizar un evento
export const eventStartUpdate = ( event ) => {
    return async(dispatch) => {

        try { // llamamos el endpoint = events/id-- aqui se construye
            const resp = await fetchConToken(`events/${ event.id }`, event, 'PUT' );
            const body = await resp.json();

            if ( body.ok ) { // si todo sale bien 
                dispatch( eventUpdated( event ) ); // se hace el dispatch  y se manda el evento, event ya tiene la informacion actualizada
            } else {
                Swal.fire('Error', body.msg, 'error'); // si hay error sweet alert
            }


        } catch (error) {
            console.log(error)
        }

    }
}
//accion updated
const eventUpdated = ( event ) => ({ // el event es el body que enviamos (el evento ya acutalizado) , el objeto
    type: types.eventUpdated,
    payload: event
});

//peticion y disparo de accion del servicio delete
export const eventStartDelete = () => {
    return async ( dispatch, getState ) => {

        const { id } = getState().calendar.activeEvent; // el id se extrae del active event del calendar, el evento que se selecciono
        try {
            const resp = await fetchConToken(`events/${ id }`, {}, 'DELETE' ); //se hace la peticion al endpoint
            const body = await resp.json(); // se recibe la respuesta

            if ( body.ok ) { // si todo es ok
                dispatch( eventDeleted() ); // lanzo la accion al reducer
            } else {
                Swal.fire('Error', body.msg, 'error'); // sino imprime el erro
            }


        } catch (error) { // si la peticion falla , devuelve el error
            console.log(error)
        }

    }
}

//accion deleted
const eventDeleted = () => ({ type: types.eventDeleted });


export const eventStartLoading = () => {
    return async(dispatch) => {

        // primero hace una peticion al back para llamar a todos los eventos de la base de datos
        try {
            //esto es una peticion get, por lo cual no hay que mandar nada mas en elargumento de fetchcontoken
            const resp = await fetchConToken( 'events' ); // se le pasas el endpoint
            const body = await resp.json(); //obtenido el endpoint, se extraen el objeto de la response

            //se creo un helper prepareEvents, que transforme el end y el start en objetos de tipo date, sino eventos estaran malconstruidos
            const events = prepareEvents( body.eventos );// se manda los eventos dentro de prepareEvents para que se construyan bien transformando sus fechas a tipo date
            dispatch( eventLoaded( events ) ); // mandamos la accion que tiene los eventos que pedimos por peticion arriba al reducer para que cambie el estado inicial siempre, muestre todos los eventos registrados en la bbdd

        } catch (error) { // si hay algun error en la peticion que imprima el error
            console.log(error)
        }

    }
}

const eventLoaded = (events) => ({  // recibe los evento alojados en la bbdd, this eventLoaded will be called inside of eventstartLoading function when we already have database's data
    type: types.eventLoaded, // que es lo que le va a hacer al estado este tipo de accion?? ve al calendar reducer
    payload: events   // el conjuto de eventos
})


//accion eventlogout que reinicia y limpia la informacion de los eventos, limpia el reducer del calendario
export const eventLogout =() => ({ type: types.eventLogout });