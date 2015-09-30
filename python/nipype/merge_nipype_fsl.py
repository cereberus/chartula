from nipype.interfaces.fsl import Merge

merger = Merge()
merger.inputs.in_files = ['bold_001.nii.gz', 'bold_002.nii.gz']
merger.inputs.dimension = 't'
merger.inputs.output_type = 'NIFTI_GZ'
merger.inputs.tr = 2.5
merger.merged_file = 'merged'


