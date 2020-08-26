import React from "react";
import {
    Button
} from "@material-ui/core";
import {
    Add,
    SelectAll,
    Delete
} from "@material-ui/icons";

import ToolButtonContainer from "../../toolButtonContainer/ToolButtonContainer";

function SurveyListTools(props) {
    return(
        <ToolButtonContainer>
            <Button color="inherit">
                <Add/>
            </Button>
            <Button color="inherit" onClick={props.selectAction}>
                <SelectAll/>
            </Button>
            <Button color="inherit">
                <Delete/>
            </Button>
        </ToolButtonContainer>
    );
}

export default SurveyListTools;