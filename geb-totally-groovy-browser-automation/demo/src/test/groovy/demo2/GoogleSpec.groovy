package demo2

import geb.spock.GebReportingSpec
import content.*
import spock.lang.Stepwise

@Stepwise
class GoogleSpec extends GebReportingSpec {

    def "we go to google"() {
        when:
        to GoogleHomePage

        then:
        at GoogleHomePage
    }

    def "and search for wikipedia"() {
        when:
        search.forTerm "wikipedia"

        then:
        at GoogleResultsPage

        and:
        firstResultLink.text() == "Wikipedia"
    }

    def "the first link takes us to wikipedia"() {
        when:
        firstResultLink.click()

        then:
        waitFor { at WikipediaPage }
    }

}