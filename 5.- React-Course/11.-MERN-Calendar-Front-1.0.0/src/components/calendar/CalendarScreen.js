import React, { useState } from 'react';
import { Calendar, momentLocalizer } from 'react-big-calendar'; //se instalar calendar big
import { useDispatch, useSelector } from 'react-redux'; //dispatch para lanzar actiones y selector para elegir estados especificos del state en el store
import moment from 'moment'; // componente para trabajar con tiempo, horas dias anios etc

import { Navbar } from '../ui/Navbar';
import { messages } from '../../helpers/calendar-messages-es'; // configuracion para calendario en espanol
import { CalendarEvent } from './CalendarEvent';
import { CalendarModal } from './CalendarModal';

import { uiOpenModal } from '../../actions/ui';

import 'react-big-calendar/lib/css/react-big-calendar.css';
import 'moment/locale/es';
import { eventSetActive, eventClearActiveEvent } from '../../actions/events';
import { AddNewFab } from '../ui/AddNewFab';
import { DeleteEventFab } from '../ui/DeleteEventFab';

moment.locale('es'); //idioma en espanol

const localizer = momentLocalizer(moment);

//ESTA ES LA PANTALLA PRINCIPAL DEL CALENDAR EN ELLA SE INSERTAN LOS DEMAS COMPONENTES
export const CalendarScreen = () => {

    const dispatch = useDispatch();

    //para estar pendiente o a la escuhca del estado de la app (store)
    const { events, activeEvent } = useSelector( state => state.calendar );  // a la escucha especificamente del estado calendar del store

    const [lastView, setLastView] = useState( localStorage.getItem('lastView') || 'month' );


    const onDoubleClick = (e) => {
        // console.log(e);
        dispatch( uiOpenModal() );// se lanza la accion con el dispatch y la accion la recibe el reducer junto con el stato, cambia e openModal a true y actualiza el state
    }

    const onSelectEvent = (e) => {
        dispatch( eventSetActive( e ) );
    }

    const onViewChange = (e) => {
        setLastView(e);
        localStorage.setItem('lastView', e);
    }

    const onSelectSlot = (e) => {
        // console.log(e)
        dispatch( eventClearActiveEvent() ); //desactivar el evento (hace que se quite el boton de borrar) calendarReducer
    }


    const eventStyleGetter = ( event, start, end, isSelected ) => {
        
        const style = {
            backgroundColor: '#367CF7',
            borderRadius: '0px',
            opacity: 0.8,
            display: 'block',
            color: 'white'
        }


        return {
            style
        }
    };

    return (
        <div className="calendar-screen">
            <Navbar />
            
{/* calendar usando las librerias del calendar y con moment */}
            <Calendar
                localizer={ localizer }
                events={ events }
                startAccessor="start"
                endAccessor="end"
                messages={ messages }
                eventPropGetter={ eventStyleGetter }
                onDoubleClickEvent={ onDoubleClick }
                onSelectEvent={ onSelectEvent }
                onView={ onViewChange }
                onSelectSlot={ onSelectSlot }
                selectable={ true }
                view={ lastView }
                components={{
                    event: CalendarEvent
                }}
            />



            <AddNewFab />


            {
                (activeEvent) && <DeleteEventFab /> // si active event es true entonces que me aparezca deleteEvente compoente, u activeEvent es true cuando seleccionamos un evento ya creado
            }
            

            <CalendarModal />



        </div>
    )
}
