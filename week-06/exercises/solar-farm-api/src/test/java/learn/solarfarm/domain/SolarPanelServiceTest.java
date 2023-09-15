package learn.solarfarm.domain;

import learn.solarfarm.data.SolarPanelRepositoryDouble;
import learn.solarfarm.models.Material;
import learn.solarfarm.models.SolarPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

import static learn.solarfarm.TestHelper.*;
import static learn.solarfarm.domain.SolarPanelService.MAX_ROW_COLUMN;
import static org.junit.jupiter.api.Assertions.*;

class SolarPanelServiceTest {

    SolarPanelService service;

    @BeforeEach
    void setup() {
        SolarPanelRepositoryDouble repository = new SolarPanelRepositoryDouble();
        service = new SolarPanelService(repository);
    }

    @Test
    void shouldFindBySection_red() {
        var expected = List.of(makePanel(1), makePanel(2), makePanel(3));
        var actual = service.findBySection("red");
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindBySection_yellow() {
        var expected = List.of();
        var actual = service.findBySection("yellow");
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByKey_red_1_1() {
        SolarPanel expected = makePanel(1);
        SolarPanel actual = service.findByKey("red", 1, 1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindByKey_yellow_1_1() {
        SolarPanel actual = service.findByKey("yellow", 1, 1);
        assertNull(actual);
    }

    @Test
    void shouldNotCreateNull() {
        SolarPanelResult expected = makeResult("SolarPanel cannot be null.", null);
        SolarPanelResult actual = service.create(null);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotCreateNullSection() {
        SolarPanel arg = makePanel(1);
        arg.setId(0);
        arg.setSection(null);

        SolarPanelResult expected = makeResult("SolarPanel `section` is required.", null);
        SolarPanelResult actual = service.create(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotCreateEmptySection() {
        SolarPanel arg = makePanel(1);
        arg.setId(0);
        arg.setSection(" ");

        SolarPanelResult expected = makeResult("SolarPanel `section` is required.", null);
        SolarPanelResult actual = service.create(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotCreateNullMaterial() {
        SolarPanel arg = makePanel(1);
        arg.setId(0);
        arg.setMaterial(null);

        SolarPanelResult expected = makeResult("SolarPanel `material` is required.", null);
        SolarPanelResult actual = service.create(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotCreateNonPositiveRow() {
        SolarPanel arg = makePanel(1);
        arg.setId(0);
        arg.setRow(0);

        String message = String.format(
                "SolarPanel `row` must be a positive number less than or equal to %s.",
                MAX_ROW_COLUMN);
        SolarPanelResult expected = makeResult(message, null);
        SolarPanelResult actual = service.create(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotCreateGreaterThanMaxRow() {
        SolarPanel arg = makePanel(1);
        arg.setId(0);
        arg.setRow(MAX_ROW_COLUMN + 1);

        String message = String.format(
                "SolarPanel `row` must be a positive number less than or equal to %s.",
                MAX_ROW_COLUMN);
        SolarPanelResult expected = makeResult(message, null);
        SolarPanelResult actual = service.create(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotCreateNonPositiveColumn() {
        SolarPanel arg = makePanel(1);
        arg.setId(0);
        arg.setColumn(0);

        String message = String.format(
                "SolarPanel `column` must be a positive number less than or equal to %s.",
                MAX_ROW_COLUMN);
        SolarPanelResult expected = makeResult(message, null);
        SolarPanelResult actual = service.create(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotCreateGreaterThanMaxColumn() {
        SolarPanel arg = makePanel(1);
        arg.setId(0);
        arg.setColumn(MAX_ROW_COLUMN + 1);

        String message = String.format(
                "SolarPanel `column` must be a positive number less than or equal to %s.",
                MAX_ROW_COLUMN);
        SolarPanelResult expected = makeResult(message, null);
        SolarPanelResult actual = service.create(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotCreateYearInstalledInTheFuture() {
        SolarPanel arg = makePanel(1);
        arg.setId(0);
        arg.setYearInstalled(LocalDate.now().getYear() + 1);

        SolarPanelResult expected = makeResult("SolarPanel `yearInstalled` must be in the past.", null);
        SolarPanelResult actual = service.create(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotCreateNonUniqueSectionRowColumn() {
        SolarPanel arg = makePanel(1);
        arg.setId(0);

        SolarPanelResult expected = makeResult("SolarPanel `section`, `row`, and `column` must be unique.", null);
        SolarPanelResult actual = service.create(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotCreatePositiveId() {
        SolarPanel arg = makePanel(1);

        SolarPanelResult expected = makeResult("SolarPanel `id` should not be set.", null);
        SolarPanelResult actual = service.create(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCreate() {
        SolarPanel arg = makePanel(5);
        arg.setId(0);
        SolarPanelResult expected = makeResult(null, arg);
        SolarPanelResult actual = service.create(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotUpdateEmptySection() {
        SolarPanel arg = makePanel(1);
        arg.setSection(" ");

        SolarPanelResult expected = makeResult("SolarPanel `section` is required.", null);
        SolarPanelResult actual = service.update(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotUpdateNonPositiveId() {
        SolarPanel arg = makePanel(1);
        arg.setSection("yellow");
        arg.setId(0);

        SolarPanelResult expected = makeResult("SolarPanel `id` should be set.", null);
        SolarPanelResult actual = service.update(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotUpdateNonExistentSolarPanel() {
        SolarPanel arg = makePanel(MISSING_ID);

        SolarPanelResult expected = makeResult("Could not update panel id 25.", null);
        SolarPanelResult actual = service.update(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldUpdate() {
        SolarPanel arg = makePanel(1);
        arg.setSection("yellow");

        SolarPanelResult expected = makeResult(null, null);
        SolarPanelResult actual = service.update(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotDeleteNonExistentSolarPanel() {
        SolarPanelResult expected = makeResult("Could not delete panel id 25.", null);
        SolarPanelResult actual = service.deleteById(MISSING_ID);
        assertEquals(expected, actual);
    }

    @Test
    void shouldDelete() {
        SolarPanelResult expected = makeResult(null, null);
        SolarPanelResult actual = service.deleteById(5);
        assertEquals(expected, actual);
    }
}
