package grailsmapwithdefaultdatabinding

import static org.junit.Assert.*
import org.junit.*
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes

class DataBindingTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testMapDatabinding() {
       def rawParams = [
          'contentByLocale[en].text': 'Content'
        ]
       def controller = new LocalizableContentController()
       controller.request.addParameters(rawParams)
       controller.request.setAttribute(GrailsApplicationAttributes.CONTROLLER, controller)
       println controller.params
       def localizableContent = new LocalizableContent(controller.params)
       println localizableContent
       println localizableContent?.contentByLocale?.text
       assert localizableContent?.contentByLocale['en']?.text == 'Content'
    }
    
    @Test
    void testMapByDefaultWithNoDatabinding() {
       assert new LocalizableContent().contentByLocale['en']?.getClass() == Text
    }
}
