package wk9.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.OptionalInt;

/**
 * Represents a record from the covidtracking.com data set.
 * https://covidtracking.com/about-data/data-definitions
 */
public class Entry {
    /**
     * DATE date the data was collected
     */
    public final LocalDate date;
    /**
     * STATE two-letter abbreviation
     */
    public final String state;
    /**
     * CASES Confirmed plus probable cases of COVID-19
     */
    public final OptionalInt positive;
    /**
     * CONFIRMED CASES unique people with a positive PCR or other approved
     * nucleic acid amplification test
     */
    public final OptionalInt positiveCasesViral;
    /**
     * NEW CASES The daily increase in CASES (Confirmed plus probable)
     */
    public final OptionalInt positiveIncrease;
    /**
     * NEGATIVE PCR TESTS (PEOPLE) - Unique people with a completed PRC test that returns negative
     */
    public final OptionalInt negative;
    /**
     * NEGATIVE PCR TESTS (SPECIMENS) completed PCR tests (or specimens tested) that return negative
     */
    public final OptionalInt negativeTestsViral;
    /**
     * POSITIVE PCR TESTS (SPECIMENS) completed PCR tests (or specimens tested) that return positive
     */
    public final OptionalInt positiveTestsViral;
    /**
     * TOTAL PCR TESTS (PEOPLE) unique people tested at least once via PCR testing
     */
    public final OptionalInt totalTestsPeopleViralIncrease;
    /**
     * TOTAL PCR TESTS (SPECIMENS) total number of PCR tests (or specimens tested)
     */
    public final OptionalInt totalTestsViral;
    /**
     * TOTAL PCR TESTS (TEST ENCOUNTERS) number of people tested per day via PCR testing
     */
    public final OptionalInt totalTestEncountersViral;
    /**
     * NEGATIVE ANTIBODY TESTS (PEOPLE) unique people with complete antibody tests that return negative
     */
    public final OptionalInt negativeTestsPeopleAntibody;
    /**
     * NEGATIVE ANTIBODY TESTS (SPECIMENS) completed antibody tests that return negative
     */
    public final OptionalInt negativeTestsAntibody;
    /**
     * POSITIVE ANTIBODY TESTS (PEOPLE) unique people with complete antibody tests that return positive
     */
    public final OptionalInt positiveTestsPeopleAntibody;
    /**
     * POSITIVE ANTIBODY TESTS (SPECIMENS) completed antibody tests that return positive
     */
    public final OptionalInt positiveTestsAntibody;
    /**
     * TOTAL ANTIBODY TESTS (PEOPLE) unique people who have been tested at least once via antibody testing
     */
    public final OptionalInt totalTestsPeopleAntibody;
    /**
     * TOTAL ANTIBODY TESTS (SPECIMENS) completed antibody tests
     */
    public final OptionalInt totalTestsAntibody;
    /**
     * POSITIVE ANTIGEN TESTS (PEOPLE) unique people with completed antigen tests that returned positive
     */
    public final OptionalInt positiveTestsPeopleAntigen;
    /**
     * POSITIVE ANTIGEN TESTS (SPECIMENS) completed antigen tests that return positive
     */
    public final OptionalInt positiveTestsAntigen;
    /**
     * TOTAL ANTIGEN TESTS (PEOPLE) unique people who have been tested at least once via antigen testing
     */
    public final OptionalInt totalTestsPeopleAntigen;
    /**
     * TOTAL ANTIGEN TESTS (SPECIMENS) completed antigen tests
     */
    public final OptionalInt totalTestsAntigen;
    /**
     * CUMULATIVE HOSPITALIZED/EVER HOSPITALIZED ever been hospitalized with COVID-19
     */
    public final OptionalInt hospitalizedCumulative;
    /**
     * CUMULATIVE IN ICU/EVER IN ICU ever been in the Intensive Care Unit with COVID-19
     */
    public final OptionalInt inIcuCumulative;
    /**
     * CUMULATIVE ON VENTILATOR/EVER ON VENTILATOR ever been hospitalized under advanced ventilation with COVID-19
     */
    public final OptionalInt onVentilatorCumulative;
    /**
     * CURRENTLY HOSPITALIZED currently hospitalized with COVID-19
     */
    public final OptionalInt hospitalizedCurrently;
    /**
     * CURRENTLY IN ICU currently in the Intensive Care Unit with COVID-19
     */
    public final OptionalInt inIcuCurrently;
    /**
     * CURRENTLY ON VENTILATOR currently hospitalized under advanced ventilation with COVID-19
     */
    public final OptionalInt onVentilatorCurrently;
    /**
     * NEW TOTAL HOSPITALIZATIONS
     */
    public final OptionalInt hospitalizedIncrease;
    /**
     * DEATHS (CONFIRMED AND PROBABLE) fatalities with confirmed OR probable COVID-19 case diagnosis
     */
    public final OptionalInt death;
    /**
     * DEATHS (CONFIRMED) fatalities with confirmed COVID-19 case diagnosis
     */
    public final OptionalInt deathConfirmed;
    /**
     * DEATHS (PROBABLE) fatalities with probable COVID-19 case diagnosis
     */
    public final OptionalInt deathProbable;
    /**
     * NEW DEATHS
     */
    public final OptionalInt deathIncrease;
    /**
     * RECOVERED people that are identified as recovered from COVID-19
     */
    public final OptionalInt recovered;
    /**
     * NEW TESTS
     */
    public final OptionalInt totalTestResultsIncrease;
    /**
     * TOTAL TEST RESULTS estimate of total tests
     */
    public final OptionalInt totalTestResults;
    public final String dataQualityGrade;
    public final OptionalInt hospitalized;
    public final OptionalInt negativeIncrease;
    public final OptionalInt positiveScore;
    public final OptionalInt totalTestEncountersViralIncrease;
    public final OptionalInt totalTestsPeopleViral;
    public final OptionalInt totalTestsViralIncrease;

    public Entry(String line) {
        String[] elements = line.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        date = LocalDate.parse(elements[0].substring(1,elements[0].length()-1), formatter);
        state = elements[1].isEmpty() ? "" : elements[1].substring(1,elements[1].length()-1);
        dataQualityGrade = elements[2].isEmpty() ? "" : elements[2].substring(1,elements[2].length()-1);
        death =                            stringToInt(elements[3]);
        deathConfirmed =                   stringToInt(elements[4]);
        deathIncrease =                    stringToInt(elements[5]);
        deathProbable =                    stringToInt(elements[6]);
        hospitalized =                     stringToInt(elements[7]);
        hospitalizedCumulative =           stringToInt(elements[8]);
        hospitalizedCurrently =            stringToInt(elements[9]);
        hospitalizedIncrease =             stringToInt(elements[10]);
        inIcuCumulative =                  stringToInt(elements[11]);
        inIcuCurrently =                   stringToInt(elements[12]);
        negative =                         stringToInt(elements[13]);
        negativeIncrease =                 stringToInt(elements[14]);
        negativeTestsAntibody =            stringToInt(elements[15]);
        negativeTestsPeopleAntibody =      stringToInt(elements[16]);
        negativeTestsViral =               stringToInt(elements[17]);
        onVentilatorCumulative =           stringToInt(elements[18]);
        onVentilatorCurrently =            stringToInt(elements[19]);
        positive =                         stringToInt(elements[20]);
        positiveCasesViral =               stringToInt(elements[21]);
        positiveIncrease =                 stringToInt(elements[22]);
        positiveScore =                    stringToInt(elements[23]);
        positiveTestsAntibody =            stringToInt(elements[24]);
        positiveTestsAntigen =             stringToInt(elements[25]);
        positiveTestsPeopleAntibody =      stringToInt(elements[26]);
        positiveTestsPeopleAntigen =       stringToInt(elements[27]);
        positiveTestsViral =               stringToInt(elements[28]);
        recovered =                        stringToInt(elements[29]);
        totalTestEncountersViral =         stringToInt(elements[30]);
        totalTestEncountersViralIncrease = stringToInt(elements[31]);
        totalTestResults =                 stringToInt(elements[32]);
        totalTestResultsIncrease =         stringToInt(elements[33]);
        totalTestsAntibody =               stringToInt(elements[34]);
        totalTestsAntigen =                stringToInt(elements[35]);
        totalTestsPeopleAntibody =         stringToInt(elements[36]);
        totalTestsPeopleAntigen =          stringToInt(elements[37]);
        totalTestsPeopleViral =            stringToInt(elements[38]);
        totalTestsPeopleViralIncrease =    stringToInt(elements[39]);
        totalTestsViral =                  stringToInt(elements[40]);
        totalTestsViralIncrease =          stringToInt(elements[41]);

    }

    private static OptionalInt stringToInt(String element) {
        return element.isEmpty() ? OptionalInt.empty()
                : OptionalInt.of(Integer.parseInt(element));
    }
}
