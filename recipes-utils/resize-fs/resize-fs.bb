DESCRIPTION = "Custom init.d script for boot setup"
LICENSE = "CLOSED"

SRC_URI = "file://resize-filesystem.sh"

S = "${WORKDIR}"

inherit update-rc.d

INITSCRIPT_NAME = "resize-filesystem"
INITSCRIPT_PARAMS = "defaults 99"

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/resize-filesystem.sh ${D}${sysconfdir}/init.d/resize-filesystem
}
