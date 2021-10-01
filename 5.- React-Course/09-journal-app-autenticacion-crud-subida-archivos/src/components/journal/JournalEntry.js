import React from 'react';
import moment from 'moment';
import { useDispatch } from 'react-redux';
import { activeNote } from '../../actions/notes';

export const JournalEntry = ({ id, date, title, body, url }) => {

    const noteDate = moment(date); // usando momento Js
    const dispatch = useDispatch();


    // se le manda el elemento seleccionado dentro del array notes
    const handleEntryClick = () => {
        dispatch( 
            // el segundo argumento tmb es el objeto
            activeNote( id, {
                date, title, body, url
            })
        );
    }

    return (
        <div 
            className="journal__entry pointer animate__animated animate__fadeIn animate__faster"
            onClick={ handleEntryClick } // manejamos el click
        >
            
            {
                url &&
                <div 
                    className="journal__entry-picture"
                    style={{
                        backgroundSize: 'cover',
                        backgroundImage: `url(${ url })`
                    }}
                ></div>
            }

            <div className="journal__entry-body">
                <p className="journal__entry-title">
                    { title }
                </p>
                <p className="journal__entry-content">
                    { body }
                </p>
            </div>

            <div className="journal__entry-date-box">
                <span> { noteDate.format('dddd') } </span> {/** usando moment JS para formato de las fechas  como el new date de javascritp */}
                <h4> { noteDate.format('Do') } </h4>{/** usando el formato correspondiente */}
            </div>

        </div>
    )
}
