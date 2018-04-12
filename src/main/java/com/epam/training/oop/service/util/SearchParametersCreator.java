package com.epam.training.oop.service.util;

import com.epam.training.oop.entity.criteria.CriteriaMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchParametersCreator {
    public static <T> List<String> createSearchParameters(CriteriaMap criteria){
        Map<T, Object> parametersMap = criteria.getCriteria();
        List<String> criteriaList = new ArrayList<>();
        criteriaList.add(criteria.getDeviceType());
        for (Map.Entry<T, Object> parameters : parametersMap.entrySet()){
            String type = parameters.getKey().toString();
            String value = parameters.getValue().toString();
            StringBuilder regExpBuilder = new StringBuilder();
            regExpBuilder
                    .append(".*\\s")
                    .append(type)
                    .append("=")
                    .append(value.toUpperCase())
                    .append("\\s.*");
            String searchParameter = regExpBuilder.toString();
            criteriaList.add(searchParameter);
        }
        return criteriaList;
    }
}
