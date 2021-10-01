import React from 'react'
import { NotesAppBar } from './NotesAppBar'

export const NoteScreen = () => {
    return (
        <div className="notes__main-content"> {/**  sera nuestro main de los styles en noteScreen */}
            
            <NotesAppBar />


            <div className="notes__content">{/**agrupador del formulario, agrupa el input, la textarea y la imagen contenida en su propio div */}

                <input //input titulo de la nota
                    type="text"
                    placeholder="Some awesome title"
                    className="notes__title-input"
                    autoComplete="off" //sin autocompletado
                />

                <textarea // area de texto de la nota descripcion
                    placeholder="What happened today"
                    className="notes__textarea"
                ></textarea>

                <div className="notes__image">
                    <img 
                        src="https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg"
                        alt="imagen"
                    />
                </div>


            </div>

        </div>
    )
}
