import React from 'react';
import CardTaco from './CardTaco.js';

function GroupTacos(props) {

    return (
        <div className="group-tacos">
            {
                props.tacos.map(taco => (
                    <CardTaco key={taco.id} eachTaco={taco} />
                ))
            }
        </div>
    );
}

export default GroupTacos;