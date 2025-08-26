DESCRIPTION = "WiFi Setup Scripts for Boot and Shutdown with WPA Supplicant"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"

SRC_URI = "file://wifi-setup-start.sh \
           file://wifi-setup-stop.sh \
           file://wpa_supplicant.conf"

S = "${WORKDIR}"

inherit update-rc.d

INITSCRIPT_NAME = "wifi-setup-start.sh"
INITSCRIPT_PARAMS = "defaults 90"

do_install() {
    # Init.d script
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/wifi-setup-start.sh ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
    install -m 0755 ${WORKDIR}/wifi-setup-stop.sh  ${D}${sysconfdir}/init.d/

    # WPA Supplicant configuration
    install -d ${D}${sysconfdir}/wifi
    install -m 0644 ${WORKDIR}/wpa_supplicant.conf ${D}${sysconfdir}/wifi/wpa_supplicant.conf
}

FILES:${PN} += "${sysconfdir}"
RDEPENDS:${PN} = "wpa-supplicant"
