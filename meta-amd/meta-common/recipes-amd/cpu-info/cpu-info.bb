SUMMARY = "AMD CPU Info"
DESCRIPTION = "CPU Info monitors the dbus interface\
xyz.openbmc_project.Inventory.Item.Cpu_info.service for Processor property \
and applies the CPU values to the SOC using esmi oob library API's"

SRC_URI = "git://github.com/AMDESE/bmc-cpuinfo.git;protocol=https;branch=main"
SRCREV = "f2f84a7f72fd8a6e15c1fad7b0a22d4178c6aa44"

S = "${WORKDIR}/git"

LICENSE = "CLOSED"

inherit cmake pkgconfig systemd

def get_service(d):
      return "xyz.openbmc_project.Inventory.Item.Cpu_info.service"

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

FILES:${PN}  += "${systemd_system_unitdir}/xyz.openbmc_project.Inventory.Item.Cpu_info.service"



