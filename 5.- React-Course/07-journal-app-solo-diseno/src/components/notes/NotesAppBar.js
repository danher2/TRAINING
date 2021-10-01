import React from 'react'

export const NotesAppBar = () => {
    //es el navbar del main de notes
    return (
        <div className="notes__appbar">
            <span>28 de agosto 2020</span>

            <div>
                {/* boton para cargar imagenes */}
                <button className="btn">
                    Picture
                </button>
{/* boton para guardar nota */}
                <button className="btn">
                    Save
                </button>
            </div>
        </div>
    )
}
