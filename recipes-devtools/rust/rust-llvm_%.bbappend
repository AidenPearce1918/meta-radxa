# Turn off LLVM's Werror globally

# Limit parallelism only for rust-llvm-native
PARALLEL_MAKE = "-j2"

# Force Rust to build with GCC 12
GCCVERSION = "12.%"

# Ensure gcc-12 and g++-12 binaries are available in HOSTTOOLS
HOSTTOOLS += "gcc-12 g++-12"

# Map them to standard gcc/g++
# do_configure[depends] += "gcc-12:do_populate_sysroot g++-12:do_populate_sysroot"

# export CC = "gcc-12"
# export CXX = "g++-12"

EXTRA_OECMAKE:append = " -DLLVM_ENABLE_WERROR=OFF"

# Belt-and-suspenders: make sure compiler flags also prevent warnings-as-errors,
# and silence the specific GCC 11/12 warning you're seeing.
CFLAGS:append:class-native = " -Wno-error -Wno-error=attributes -Wno-dangling-pointer"
CXXFLAGS:append:class-native = " -Wno-error -Wno-error=attributes -Wno-dangling-pointer"

# (Optional) If your build env still forces Werror via other paths, force CMake flags too.
EXTRA_OECMAKE:append = " -DCMAKE_C_FLAGS='${CFLAGS}' -DCMAKE_CXX_FLAGS='${CXXFLAGS}'"
