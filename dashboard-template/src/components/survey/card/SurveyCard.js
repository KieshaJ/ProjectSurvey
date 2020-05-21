import React from "react";
import {
    Card,
    CardContent,
    IconButton
} from "@material-ui/core";
import {
    Edit,
    Delete
} from "@material-ui/icons";
import "./SuveryCard.css";

function SurveyCard(props) {
    const statusClass = (status) => {
        switch(status) {
            case "DRAFT":
                return "draft";
            case "ACTIVE":
                return "active";
            case "INACTIVE":
                return "inactive";
            default:
                return null;
        }
    };

    return(
        <Card className="card" onClick={props.clickAction}>
            <CardContent className={props.selected ? "content selected" : "content"}>
                <div className="index">
                    {props.index + 1}
                </div>
                <div className="name">
                    {props.survey.name}
                </div>
                <div className="buttons">
                    <IconButton size="small" color="inherit">
                        <Edit/>
                    </IconButton>
                    <IconButton size="small" color="inherit">
                        <Delete/>
                    </IconButton>
                </div>
            </CardContent>
            <CardContent className={"status-indicator " + statusClass(props.survey.status)}/>
        </Card>
    );
}

export default SurveyCard;