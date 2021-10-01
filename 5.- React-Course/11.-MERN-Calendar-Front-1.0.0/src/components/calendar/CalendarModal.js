import React, { useState, useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';

import moment from 'moment';
import Modal from 'react-modal';
import DateTimePicker from 'react-datetime-picker';
import Swal from 'sweetalert2';

import { uiCloseModal } from '../../actions/ui';
import { eventAddNew, eventClearActiveEvent, eventUpdated } from '../../actions/events';


const customStyles = {
    content : {
      top                   : '50%',
      left                  : '50%',
      right                 : 'auto',
      bottom                : 'auto',
      marginRight           : '-50%',
      transform             : 'translate(-50%, -50%)'
    }
};
Modal.setAppElement('#root');

const now = moment().minutes(0).seconds(0).add(1,'hours'); // 3:00:00
const nowPlus1 = now.clone().add(1, 'hours');

const initEvent = {
    title: '',
    notes: '',
    start: now.toDate(),
    end: nowPlus1.toDate()
}


export const CalendarModal = () => {

    //para estar pendiente o a la escuhca del estado de la app (store)
//desestructuracion , modalOpen y abajo activeEvent
    const { modalOpen } = useSelector( state => state.ui );// a la escucha especificamente del estado ui del store
    const { activeEvent } = useSelector( state => state.calendar ); // a la escucha especificamente del estado calendar del store

    //para poder lanzar acciones
    const dispatch = useDispatch();

    //fijo estados para mi hora inicial y final
    const [ dateStart, setDateStart ] = useState( now.toDate() );
    const [ dateEnd, setDateEnd ] = useState( nowPlus1.toDate() );

    const [ titleValid, setTitleValid ] = useState(true);
    
    const [formValues, setFormValues] = useState( initEvent );

    const { notes, title, start, end } = formValues; // extraemos los atributos de formvalues (initEvent) para despues establecerlos en el form

    useEffect(() => {
        if ( activeEvent ) { // si activeEvent existe y es diferente de null, entonces es un evento llenado y obtiene los datos de ese evento en un objeto
            setFormValues( activeEvent );// seteamos esa info de ese evento al estado del forvalues
        } else {
            setFormValues( initEvent ); // sino entonces, es otra fecha sin evento y ponle el estado inicial 
        }
    }, [activeEvent, setFormValues])// --> siempre y cuando estas dependencias cambien se realizara lo que esta en el body del useEffect


//evento
    const handleInputChange = ({ target }) => {
        setFormValues({
            ...formValues,
            [target.name]: target.value // target = unicamente cambio el que viene como argumento en este evento, ahi desestructuro un arreglo
        });

        
    }


    const closeModal = () => {
        // TODO: cerrar el modal
        dispatch( uiCloseModal() ); // se lanza la accion con el dispatch y la accion la recibe el reducer junto con el stato, cambia e closeModal a false y actualiza el state
        dispatch( eventClearActiveEvent() );//limpiar nota activa al cerrar la nota
        setFormValues( initEvent ); // se limpia el state  despues de cerrarr , me regresa al estado inicial
    }

    //evento
    const handleStartDateChange = ( e ) => {
        setDateStart( e );
        setFormValues({
            ...formValues,
            start: e
        })
    }
    

    //evento
    const handleEndDateChange = ( e ) => {
        setDateEnd( e );
        setFormValues({
            ...formValues,
            end: e
        })
    }


    //evento
    const handleSubmitForm = (e) => {
        e.preventDefault();
        
        const momentStart = moment( start );
        const momentEnd = moment( end );

        //validaciones de los campos del form (los atributos del objeto que forman)

        if ( momentStart.isSameOrAfter( momentEnd ) ) {
            return Swal.fire('Error','La fecha fin debe de ser mayor a la fecha de inicio', 'error'); //sweet alert 2
        }

        if ( title.trim().length < 2 ) {
            return setTitleValid(false);
        }

        if ( activeEvent ) { // si hay informacion, si exite con algo diferente de null seria para  actualizar
            dispatch( eventUpdated( formValues ) )  // se actualiza y el estado actual con la info 
        } else {
            dispatch( eventAddNew({ // sino entonces quere decir que es un nuevo evento
                ...formValues,
                id: new Date().getTime(),
                user: {
                    _id: '123',
                    name: 'Fernando'
                }
            }) );
        }


        setTitleValid(true);
        closeModal();
        
    }


    return (
        <Modal
          isOpen={ modalOpen }
          onRequestClose={ closeModal } //closeModal funcion constriuda en esta clase
          style={ customStyles }
          closeTimeoutMS={ 200 }
          className="modal"
          overlayClassName="modal-fondo"
        >
            <h1> { (activeEvent)? 'Editar evento': 'Nuevo evento' } </h1> {/* si existe (diferente de null) entonces editar evento sino nuevo evento */}
            
            <hr />
            <form 
                className="container"
                onSubmit={ handleSubmitForm }
            >

                <div className="form-group">
                    <label>Fecha y hora inicio</label>
                    <DateTimePicker
                        onChange={ handleStartDateChange } //cuado cambia el picker
                        value={ dateStart }
                        className="form-control"
                    />
                </div>

                <div className="form-group">
                    <label>Fecha y hora fin</label>
                    <DateTimePicker
                        onChange={ handleEndDateChange }
                        value={ dateEnd }
                        minDate={ dateStart }
                        className="form-control"
                    />
                </div>

                <hr />
                <div className="form-group">
                    <label>Titulo y notas</label>
                    <input 
                        type="text" 
                        className={ `form-control ${ !titleValid && 'is-invalid' } `}
                        placeholder="Título del evento"
                        name="title"
                        autoComplete="off"
                        value={ title } // puede vacio si no se ha hecho evento o devuelve el dato si ya es un evento creado
                        onChange={ handleInputChange }
                    />
                    <small id="emailHelp" className="form-text text-muted">Una descripción corta</small>
                </div>

                <div className="form-group">
                    <textarea 
                        type="text" 
                        className="form-control"
                        placeholder="Notas"
                        rows="5"
                        name="notes"
                        value={ notes } // puede vacio si no se ha hecho evento o devuelve el dato si ya es un evento creado
                        onChange={ handleInputChange }
                    ></textarea>
                    <small id="emailHelp" className="form-text text-muted">Información adicional</small>
                </div>

                <button
                    type="submit"
                    className="btn btn-outline-primary btn-block"
                >
                    <i className="far fa-save"></i>
                    <span> Guardar</span>
                </button>

            </form>

        </Modal>
    )
}
