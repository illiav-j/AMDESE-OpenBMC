SUMMARY = "OpenBMC for AMD - Applications"
PR = "r1"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " \
        ${PN}-chassis \
        ${PN}-fans \
        ${PN}-flash \
        ${PN}-system \
        "

PROVIDES += "virtual/obmc-chassis-mgmt"
PROVIDES += "virtual/obmc-flash-mgmt"
PROVIDES += "virtual/obmc-fan-mgmt"
PROVIDES += "virtual/obmc-system-mgmt"

RPROVIDES:${PN}-chassis += "virtual-obmc-chassis-mgmt"
RPROVIDES:${PN}-fans += "virtual-obmc-fan-mgmt"
RPROVIDES:${PN}-flash += "virtual-obmc-flash-mgmt"
RPROVIDES:${PN}-system += "virtual-obmc-system-mgmt"

SUMMARY:${PN}-chassis = "AMD Chassis"
RDEPENDS:${PN}-chassis = " \
        amd-power-control \
        phosphor-sel-logger \
        phosphor-logging \
        "

SUMMARY:${PN}-fans = "AMD Fans"
RDEPENDS:${PN}-fans = "phosphor-pid-control"

SUMMARY:${PN}-flash = "AMD Flash"
RDEPENDS:${PN}-flash = " \
        phosphor-software-manager \
        "

SUMMARY:${PN}-system = "AMD System"
RDEPENDS:${PN}-system = " \
        amd-apml \
        amd-clear-cmos \
        amd-dimm \
        amd-lcd-lib \
        amd-mctp-tool \
        amd-ras \
        bmcweb \
        cpu-info \
        debug-apps \
        first-boot-set-hwmon-path \
        fpga-tools \
        i3c-tools \
        ipmitool \
        phosphor-hostlogger \
        phosphor-pid-control \
        phosphor-host-postd \
        phosphor-post-code-manager \
        power-capping \
        phosphor-misc-usb-ctrl \
        set-fan-speed \
        set-associations-path \
        usb-network \
        vr-update \
        webui-vue \
        "
