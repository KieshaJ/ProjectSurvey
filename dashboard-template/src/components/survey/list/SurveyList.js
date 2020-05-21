import React, {useState, useEffect} from "react";
import axios from "axios";
import "./SurveyList.css";

import SurveyListTools from "../tools/SurveyListTools";
import SurveyCard from "../card/SurveyCard";

function SurveyList() {
    const [filter, setFilter] = useState({page: 0, pageSize: 20});
    const [totalSurveys, setTotalSurveys] = useState(0);
    const [selectedSurveyIds, setSelectedSurveyIds] = useState([]);
    const [surveyList, setSurveyList] = useState([]);

    useEffect(() => {
        const fetchSurveys = async () => {
            await axios.post("http://localhost:8080/surveys", filter).then(res => {
                setSurveyList(res.data.surveys.content);
                setTotalSurveys(res.data.surveys.totalElements);
            });
        };

        fetchSurveys();
    }, [filter]);

    const selectSurvey = (id) => {
        if (selectedSurveyIds.includes(id)) {
            setSelectedSurveyIds(selectedSurveyIds.filter(s => s !== id));
        } else {
            setSelectedSurveyIds([...selectedSurveyIds, id]);
        }
    }

    const selectAll = () => {
        let selected = [];

        if (selectedSurveyIds.length < surveyList.length) {
            surveyList.forEach(survey => selected.push(survey.idAsString));
        }

        setSelectedSurveyIds(selected);
    };

    const renderSurveyCounts = () => {
        const first = filter.page * filter.pageSize + 1;
        const offset = totalSurveys < filter.pageSize ? totalSurveys : (filter.page + 1) * filter.pageSize;

        return (
            <div className="survey-counts">
                <span>
                    {"Surveys " + first + " - " + offset + " of " + totalSurveys}
                </span>
            </div>
        );
    };

    return (
        <div className="survey-list">
            <SurveyListTools selectAction={() => selectAll()}/>
            {renderSurveyCounts()}
            <div className="list">
                {surveyList.map((survey, index) => (
                    <SurveyCard
                        key={survey.idAsString}
                        selected={selectedSurveyIds.includes(survey.idAsString)}
                        survey={survey}
                        index={index}
                        clickAction={() => selectSurvey(survey.idAsString)}
                    />
                ))}
            </div>
        </div>
    );
}

export default SurveyList;