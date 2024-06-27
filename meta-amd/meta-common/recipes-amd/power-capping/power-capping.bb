SUMMARY = "AMD power capping"
DESCRIPTION = "Power capping monitors the dbus interface\
xyz.openbmc_project.Control.Host.Power_cap.service for PowerCap property \
and applies the power cap values to the SOC using esmi oob library API's"

SRC_URI = "git://github.com/AMDESE/amd-power-cap.git;protocol=https;branch=main"
SRCREV = "8ad293b364e27d741242a4ce818d2e8ff26484ee"

SRC_URI += "\
            file://0001-Fix-UB-on-getProperty-failure.patch \
            file://0002-Fix-popen-return-value-check.patch \
            file://0003-Fix-systemd-unit-install-path.patch \
            file://0004-Switch-to-CPP20.patch \
            "

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



