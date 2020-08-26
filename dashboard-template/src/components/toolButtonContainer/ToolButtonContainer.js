import React from "react";
import "./ToolButtonContainer.css";

const ToolButtonContainer = (props) => {
    const buttons = props.children;

    return(
        <div className="tool-button-container">
            {buttons}
        </div>
    );
};

export default ToolButtonContainer;