SUMMARY = "Pre Configure apt sources.list and time sync using curl on boot"
DESCRIPTION = "Sets up /etc/apt/sources.list for Ubuntu and ensures time is synced using curl (init.d style)"

LICENSE = "OSL-3.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/OSL-3.0;md5=438ec6d864bbb958a49df939a56511cf"


SRC_URI = " \
	file://sources.list \
	file://time-sync.sh \
"

S = "${WORKDIR}"

do_install() {
    # 1. Configure sources.list
    install -d ${D}/${sysconfdir}/apt
    install -m 0644 ${S}/sources.list ${D}/${sysconfdir}/apt/sources.list

    # 2. Install the time sync script
    install -d ${D}${bindir}
    install -m 0644 ${S}/time-sync.sh ${D}${bindir}/time-sync.sh
}

FILES:${PN} += " \
                ${bindir}/* \
                ${sysconfdir}/* "

