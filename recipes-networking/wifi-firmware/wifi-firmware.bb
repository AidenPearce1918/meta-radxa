SUMMARY = "Radxa AIC8800 WiFi driver and tools"
DESCRIPTION = "AIC8800 driver and test tools for Radxa platforms"
HOMEPAGE = "https://github.com/radxa-pkg/aic8800"
LICENSE = "GPL-2.0-only"

LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/radxa-pkg/aic8800.git;protocol=https;branch=main"

SRC_URI[sha256sum] = "b339ab27062c47a50d7f66ea9d08a571a408390e32a158c08684101fc1395d21"
SRCREV = "5da091f8250d2e59750af671df97024f7ae87084"

S = "${WORKDIR}/git"

# Add any build-time deps
DEPENDS += "virtual/kernel coreutils-native"

# Provide kernel modules
RPROVIDES:${PN} += "kernel-module-aic8800-btlpm \
                    kernel-module-aic8800-bsp \
                    kernel-module-aic8800-fdrv"

# Autoload modules at boot
KERNEL_MODULE_AUTOLOAD += "aic8800_btlpm aic8800_bsp aic8800_fdrv"

FILEEXTRAPATHS:prepend := "${S}/debian/patches/:"

inherit module

# Optional: clean builds
EXTRA_OEMAKE += "KERNELDIR=${STAGING_KERNEL_DIR}"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"


# Defaults (override in local.conf or machine.conf)
AIC8800_MODE ?= "SDIO"

do_patch() {

    cd ${S}

    if [ ! -f ${S}/debian/patches/fix-sdio-firmware-path.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-sdio-firmware-path.patch
        touch ${S}/debian/patches/fix-sdio-firmware-path.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-sdio-fall-through.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-sdio-fall-through.patch
        touch ${S}/debian/patches/fix-sdio-fall-through.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-debug-file-with-no-debug-symbols.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-debug-file-with-no-debug-symbols.patch
        touch ${S}/debian/patches/fix-debug-file-with-no-debug-symbols.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-pcie-build.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-pcie-build.patch
        touch ${S}/debian/patches/fix-pcie-build.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-pcie-firmware-path.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-pcie-firmware-path.patch
        touch ${S}/debian/patches/fix-pcie-firmware-path.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-usb-firmware-path.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-usb-firmware-path.patch
        touch ${S}/debian/patches/fix-usb-firmware-path.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-linux-6.1-build.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-linux-6.1-build.patch
        touch ${S}/debian/patches/fix-linux-6.1-build.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-aic_btusb.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-aic_btusb.patch
        touch ${S}/debian/patches/fix-aic_btusb.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-linux-6.7-build.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-linux-6.7-build.patch
        touch ${S}/debian/patches/fix-linux-6.7-build.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-linux-6.5-build.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-linux-6.5-build.patch
        touch ${S}/debian/patches/fix-linux-6.5-build.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-linux-6.9-build.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-linux-6.9-build.patch
        touch ${S}/debian/patches/fix-linux-6.9-build.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-linux-6.12-build.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-linux-6.12-build.patch
        touch ${S}/debian/patches/fix-linux-6.12-build.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-linux-6.13-build.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-linux-6.13-build.patch
        touch ${S}/debian/patches/fix-linux-6.13-build.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-linux-6.14-build.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-linux-6.14-build.patch
        touch ${S}/debian/patches/fix-linux-6.14-build.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-linux-6.15-build.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-linux-6.15-build.patch
        touch ${S}/debian/patches/fix-linux-6.15-build.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-aic_btusb-implicit-declare-compat_ptr.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-aic_btusb-implicit-declare-compat_ptr.patch
        touch ${S}/debian/patches/fix-aic_btusb-implicit-declare-compat_ptr.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-allwinner-dkms.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-allwinner-dkms.patch
        touch ${S}/debian/patches/fix-allwinner-dkms.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-linux-6.16-build.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-linux-6.16-build.patch
        touch ${S}/debian/patches/fix-linux-6.16-build.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-usb-build.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-usb-build.patch
        touch ${S}/debian/patches/fix-usb-build.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-aic_btusb-use-bluez-by-default.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-aic_btusb-use-bluez-by-default.patch
        touch ${S}/debian/patches/fix-aic_btusb-use-bluez-by-default.patched
    fi

    if [ ! -f ${S}/debian/patches/fix-usbc1-controller-wifi-rate-of-sun60iw2p1.patched ]; then
        patch -p1 < ${S}/debian/patches/fix-usbc1-controller-wifi-rate-of-sun60iw2p1.patch
        touch ${S}/debian/patches/fix-usbc1-controller-wifi-rate-of-sun60iw2p1.patched
    fi

    cd -
}

do_compile() {
    unset LDFLAGS
    oe_runmake -C ${S}/src/SDIO/driver_fw/driver/aic8800 \
	KDIR=${STAGING_KERNEL_DIR} \
	ARCH=${ARCH} 
}

do_install() { 
    # Install kernel modules 
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra 

    install -m 0644 ${S}/src/SDIO/driver_fw/driver/aic8800/aic8800_btlpm/aic8800_btlpm.ko \ 
	${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra/ 

    install -m 0644 ${S}/src/SDIO/driver_fw/driver/aic8800/aic8800_bsp/aic8800_bsp.ko \ 
	${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra/ 

    install -m 0644 ${S}/src/SDIO/driver_fw/driver/aic8800/aic8800_fdrv/aic8800_fdrv.ko \ 
	${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra/ 

    # Install firmware 
    install -d ${D}/lib/firmware/aic8800_fw/${AIC8800_MODE} 
    cp -r ${S}/src/${AIC8800_MODE}/driver_fw/fw/* ${D}/lib/firmware/aic8800_fw/${AIC8800_MODE}/ 
}

KERNEL_MODULE_PROBECONF += "aic8800_fdrv"

KERNEL_MODULE_PROBECONF[aic8800_fdrv] = "aicwf_dbg_level=0"

FILES:${PN} += "${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra \ /lib/firmware/aic8800_fw"
