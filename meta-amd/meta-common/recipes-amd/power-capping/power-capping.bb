SUMMARY = "AMD power capping"
DESCRIPTION = "Power capping monitors the dbus interface\
xyz.openbmc_project.Control.Host.Power_cap.service for PowerCap property \
and applies the power cap values to the SOC using esmi oob library API's"

SRC_URI = "git://git@github.com/AMDESE/amd-power-cap.git;branch=main;protocol=ssh"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

LICENSE = "CLOSED"

inherit cmake pkgconfig systemd

def get_service(d):
      return "xyz.openbmc_project.Control.Host.Power_cap.service"

SYSTEMD_SERVICE:${PN} = "${@get_service(d)}"

DEPENDS += " \
    amd-apml \
    i2c-tools \
    libgpiod \
    phosphor-dbus-interfaces \
    phosphor-logging \
    sdbusplus \
    "

RDEPENDS:${PN} += "amd-apml"

FILES:${PN}  += "${systemd_system_unitdir}/xyz.openbmc_project.Control.Host.Power_cap.service"



